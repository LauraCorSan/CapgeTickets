package com.capgeticket.resteventos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.response.EventoResponse;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * Clase: EventoController Descripción: clase de control (recepcion y
 * procesamiento) de endpoints Fecha: 18/10/24 Versión: 2.0 Autores: Laura
 * Gregorio, Laura Cordero, Elena, Guillermo, Veronica
 */

@RestController
@RequestMapping("/evento")
public class EventoController {
	@Autowired
	private EventoService eventoService;

	@Autowired
	private EventoAdapter eventoAdapter;

	/**
	 * Llama al servicio de evento para realizar la operacion de guardado
	 *
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento adaptado
	 */
	@PutMapping("/modificar/{id}")
	public EventoResponse modificarEvento(@PathVariable Long id, @RequestBody Evento evento) throws Exception{
		final Optional<Evento> e = eventoService.buscarPorId(id);
		if (!e.isPresent()) {
			return ;
		}
		Evento event = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(event);

	}
	

	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}

}
