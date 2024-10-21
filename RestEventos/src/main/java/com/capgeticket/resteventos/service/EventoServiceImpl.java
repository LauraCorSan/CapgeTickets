package com.capgeticket.resteventos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.error.EventoInvalidoException;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * Clase: EventoServiceImpl Descripción: clase de servicio que utiliza el
 * repositorio para la gestion de datos Fecha: 18/10/24 Versión: 2.0 Autores:
 * Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
 */
@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	EventoAdapter eventoAdapter;

	/**
	 * Llama al repositorio de evento para realizar la operacion de guardado
	 * 
	 * @author lgregori
	 * @param Recibe un objeto de tipo Evento
	 * @return Resultado de la llamada al metodo save en repositorio
	 */
	@Override
	public Evento aniadirEvento(Evento evento) {
		validarEvento(evento);
		return eventoRepository.save(evento);
	}
	
	/**
	 * LLama al repositorio, encuentra un evento por id y si está presente lo elimina, si no lanza excepción
	 * @param id
	 * @return objeto evento 
	 */

	public Evento eliminarEvento(Long id) {
		Optional<Evento> eventoOpt = eventoRepository.findById(id);
		if (eventoOpt.isPresent()) {
			Evento evento = eventoOpt.get();
			eventoRepository.delete(evento);
			return evento;

		} else {
			throw new EntityNotFoundException("Evento no encontrado con ID: " + id);
		}
	}

	/**
	 * Se encarga de validar los campos del evento para poder añadirlo
	 * 
	 * @author lgregori
	 * @param evento
	 */
	private void validarEvento(Evento evento) {
		if (evento.getNombre() == null || evento.getNombre().trim().isEmpty()) {
			throw new EventoInvalidoException("El nombre del evento no puede estar vacío.");
		}

		if (evento.getGenero() == null || evento.getGenero().trim().isEmpty())

		{
			throw new EventoInvalidoException("El género del evento no puede estar vacío.");
		}
		if (evento.getFechaEvento() == null) {
			throw new EventoInvalidoException("La fecha del evento no puede ser nula.");
		}
		if (evento.getFechaEvento().isBefore(LocalDateTime.now())) {
			throw new EventoInvalidoException("La fecha del evento no puede ser en el pasado.");
		}
		if (evento.getPrecioMin() < 0) {
			throw new EventoInvalidoException("El precio mínimo no puede ser negativo.");
		}
		if (evento.getPrecioMax() < 0) {
			throw new EventoInvalidoException("El precio máximo no puede ser negativo.");
		}
		if (evento.getPrecioMin() > evento.getPrecioMax()) {
			throw new EventoInvalidoException("El precio mínimo no puede ser mayor que el precio máximo.");
		}
		if (evento.getLocalidad() == null || evento.getLocalidad().trim().isEmpty()) {
			throw new EventoInvalidoException("La localidad no puede estar vacía.");
		}
		if (evento.getRecinto() == null || evento.getRecinto().trim().isEmpty()) {
			throw new EventoInvalidoException("El recinto no puede estar vacío.");
		}
	}

	/**
	 * Busca los detalles de un evento por su ID.
	 * 
	 * @author vparragr
	 * @param id El ID del evento que se desea buscar.
	 * @return El objeto correspondiente al ID proporcionado.
	 * @throws RuntimeException si no se encuentra un evento con el ID
	 *                          proporcionado.
	 */

	@Override
	public Evento detallesEvento(Long id) {
		return eventoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + id));

	}

	/**
	 * Llama al repositorio de evento para realizar la búsqueda por id
	 *
	 * @param Recibe un id
	 * @return Un Evento opcional
	 */
	@Override
	public Optional<Evento> buscarPorId(Long id) {
		return eventoRepository.findById(id);
	}

	/**
	 * Llama al repositorio de evento para realizar la búsqueda de todos los eventos
	 * @author elena
	 * @return Lista de Evento
	 */
	@Override
	public List<Evento> buscarTodos() {
		return eventoRepository.findAll();
	}
}
