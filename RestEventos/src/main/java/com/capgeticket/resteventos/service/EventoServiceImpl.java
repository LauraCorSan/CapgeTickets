package com.capgeticket.resteventos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	EventoAdapter eventoAdapter;

	@Override
	public Evento aniadirEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	public Evento eliminarEvento(Long id) {
		Optional <Evento> eventoOpt = eventoRepository.findById(id);
		if (eventoOpt.isPresent()) {
			Evento evento =eventoOpt.get();
			eventoRepository.delete(evento);
			return evento;
			
		}else {
			throw new EntityNotFoundException("Evento no encontrado con ID: " + id);
	    }
	}

	

	

}
