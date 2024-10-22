package com.capgeticket.resteventos.service;

import java.util.List;
import java.util.Optional;
import com.capgeticket.resteventos.model.Evento;

/**

* Interfaz: EventoService
* Descripción: interfaz que define los metodos de la clase de servicio
* Fecha: 18/10/24
* Versión: 2.0
* Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica

 * Interfaz: EventoService 
 * Descripción: interfaz que define los metodos de la
 * clase de servicio 
 * Fecha: 18/10/24
 * Versión: 2.0 
 * Autores: Laura Gregorio, Laura
 * Cordero, Elena, Guillermo, Veronica
 */

public interface EventoService {

	public Evento aniadirEvento(Evento evento);

	public Evento detallesEvento(Long id);

	public Optional<Evento> buscarPorId(Long id);

	public List<Evento> buscarTodos();

	public Evento eliminarEvento(Long id);

}