package com.capgeticket.resteventos.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

public class EventoServiceImpl implements EventoService{
	@Autowired
	EventoRepository repository;

	 /**
     * Llama al repositorio de evento para realizar la operacion de guardado
     *
     * @param Recibe un objeto de tipo Evento
     * @return Resultado de la llamada al metodo save en repositorio
     */
	@Override
	public Evento aniadirEvento (Evento evento) {
		return repository.save(evento);	
	}
	
}
