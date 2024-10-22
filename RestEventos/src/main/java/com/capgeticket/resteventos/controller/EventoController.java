package com.capgeticket.resteventos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.error.EventoNotFoundException;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.response.EventoResponse;


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
	 * lanza una excepción si no encuentra el evento
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento adaptado
	 */
	@PutMapping("/modificar/{id}")
	public EventoResponse modificarEvento(@PathVariable Long id, @RequestBody Evento evento){
		final Optional<Evento> e = eventoService.buscarPorId(id);
		e.orElseThrow(EventoNotFoundException::new);
		
		evento.setId(id);
		Evento event = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(event);

	}
	
	/**
	 * Llama al servicio de evento para realizar la operacion de guardado
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento fto
	 */
	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}
	
	@GetMapping("/delete")
    public EventoResponse deleteEvento(@RequestParam Evento evento) {
		
	        Evento eventoEliminado = eventoService.eliminarEvento(evento);
	        return eventoAdapter.toDTO(eventoEliminado);
}

	/**
	 * Busca los detalles de un evento por su ID.
	 * @author vparragr
	 * @param id El ID del evento que se desea buscar.
	 * @return El objeto correspondiente al ID proporcionado.
	 */
	@GetMapping("/{id}")
	public EventoResponse detallesEvento(@PathVariable Long id) {
         Evento evento = eventoService.detallesEvento(id);
        return eventoAdapter.toDTO(evento);
    }

}
