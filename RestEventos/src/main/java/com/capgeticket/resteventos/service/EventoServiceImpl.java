package com.capgeticket.resteventos.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.error.EventoInvalidoException;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

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
		if (evento.getFecha_evento() == null) {
			throw new EventoInvalidoException("La fecha del evento no puede ser nula.");
		}
		if (evento.getFecha_evento().isBefore(LocalDateTime.now())) {
			throw new EventoInvalidoException("La fecha del evento no puede ser en el pasado.");
		}
		if (evento.getPrecio_min() < 0) {
			throw new EventoInvalidoException("El precio mínimo no puede ser negativo.");
		}
		if (evento.getPrecio_max() < 0) {
			throw new EventoInvalidoException("El precio máximo no puede ser negativo.");
		}
		if (evento.getPrecio_min() > evento.getPrecio_max()) {
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
}
