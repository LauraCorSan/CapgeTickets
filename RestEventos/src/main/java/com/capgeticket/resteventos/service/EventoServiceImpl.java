package com.capgeticket.resteventos.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

public class EventoServiceImpl implements EventoService{
	@Autowired
	EventoRepository repository;

	@Override
	public Evento save(Evento evento) {
		return repository.save(evento);	
	}
	
}
