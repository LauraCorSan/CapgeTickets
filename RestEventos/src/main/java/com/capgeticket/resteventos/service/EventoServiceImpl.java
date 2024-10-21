package com.capgeticket.resteventos.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;

public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired EventoAdapter eventoAdapter;

	@Override
	public Evento aniadirEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	public Evento eliminarEvento(Evento evento) {
		return (Evento) eventoRepository;
	}
}
