package com.capgeticket.resteventos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;


@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired EventoAdapter eventoAdapter;

	@Override
	public Evento aniadirEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	
	  @Override 
	  public Evento detallesEvento(Long id) { 
		  Optional<Evento> evento = eventoRepository.findById(id); 
		  return evento.get();
	  
	  }
	 


}
