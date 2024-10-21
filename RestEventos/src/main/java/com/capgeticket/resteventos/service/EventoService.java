package com.capgeticket.resteventos.service;

import java.util.Optional;

import com.capgeticket.resteventos.model.Evento;
<<<<<<< HEAD

/**
* Interfaz: EventoService
* Descripción: interfaz que define los metodos de la clase de servicio
* Fecha: 18/10/24
* Versión: 2.0
* Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
*/
=======
>>>>>>> refs/remotes/origin/Vero

public interface EventoService {

	public Evento aniadirEvento(Evento evento);
<<<<<<< HEAD
	public Evento eliminarEvento(Evento evento);

	public Optional<Evento> buscarPorId(Long id);
=======
	
	
	//Obtiene los detalles de un evento por su ID.
	public Evento detallesEvento(Long id);
>>>>>>> refs/remotes/origin/Vero

}
