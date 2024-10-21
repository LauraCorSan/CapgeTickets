package com.capgeticket.resteventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;


@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired EventoAdapter eventoAdapter;

	@Override
	public Evento aniadirEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	
	/**
	 * Busca los detalles de un evento por su ID.
	 * @author vparragr
	 * @param id El ID del evento que se desea buscar.
	 * @return El objeto correspondiente al ID proporcionado.
	 * @throws RuntimeException si no se encuentra un evento con el ID proporcionado.
	 */
	
	  @Override 
	  public Evento detallesEvento(Long id) { 
		  return eventoRepository.findById(id)
			        .orElseThrow(() -> new RuntimeException("Evento no encontrado con id: " + id));
	  
	  }
	 


}
