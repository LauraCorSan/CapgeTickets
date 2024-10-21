package com.capgeticket.resteventos.service;

import com.capgeticket.resteventos.model.Evento;

public interface EventoService {
	
	public Evento aniadirEvento(Evento evento);
	
	
	//Obtiene los detalles de un evento por su ID.
	public Evento detallesEvento(Long id);

}
