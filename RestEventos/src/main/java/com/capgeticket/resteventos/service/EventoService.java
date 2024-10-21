package com.capgeticket.resteventos.service;

import java.util.Optional;

import com.capgeticket.resteventos.model.Evento;

/**
* Interfaz: EventoService
* Descripción: interfaz que define los metodos de la clase de servicio
* Fecha: 18/10/24
* Versión: 2.0
* Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
*/

public interface EventoService {

	public Evento aniadirEvento(Evento evento);
	
	
	//Obtiene los detalles de un evento por su ID.
	public Evento detallesEvento(Long id);

	public Optional<Evento> buscarPorId(Long id);

}
