package com.capgeticket.resteventos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

/**
* Clase: EventoServiceImpl
* Descripción: clase de servicio que utiliza el repositorio para la gestion de datos 
* Fecha: 18/10/24
* Versión: 2.0
* Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
*/

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired EventoAdapter eventoAdapter;

	/**
     * Llama al repositorio de evento para realizar la operacion de guardado
     *
     * @param Recibe un objeto de tipo Evento
     * @return Resultado de la llamada al metodo save en repositorio
     */
	@Override
	public Evento aniadirEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public Optional<Evento> buscarPorId(Long id) {
		return eventoRepository.findById(id);
	}
}
