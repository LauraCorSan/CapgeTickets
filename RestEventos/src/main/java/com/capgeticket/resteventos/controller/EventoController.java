package com.capgeticket.resteventos.controller;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.GetMapping;
=======

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;

>>>>>>> 2ea368cadb9cbf7a4d06102dc5b5a89ac7925a5c
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.adapter.EventoAdapter;
<<<<<<< HEAD
import com.capgeticket.resteventos.error.EventoNotFoundException;
=======

import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;

>>>>>>> 2ea368cadb9cbf7a4d06102dc5b5a89ac7925a5c
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
	 * Llama al servicio de evento para realizar la operacion de guardado lanza una
	 * excepción si no encuentra el evento
	 * 
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento adaptado
	 */
	@PutMapping("/modificar/{id}")
	public EventoResponse modificarEvento(@PathVariable Long id, @RequestBody Evento evento) {
		final Optional<Evento> e = eventoService.buscarPorId(id);
		e.orElseThrow(EventoNotFoundException::new);

		evento.setId(id);
		Evento event = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(event);

	}

	/**
	 * Llama al servicio de evento para realizar la operacion de guardado
	 * 
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento fto
	 */
	
	@Autowired EventoRepository eventoRepository;
	
	 @Autowired
	    private EventoAdapter eventoAdapter;
	 
	 @Autowired
		private EventoService eventoService;
	
	 
	 /**
	     * Solicitud GET para listar todos los eventos.
	     *
	     * @return Una lista de objetos EventoResponse que representan todos los eventos.
	     */
	    @GetMapping("/listarEventos")
	    public ResponseEntity<List<EventoResponse>> getEventoAll() {
	        List<EventoResponse> eventos = eventoAdapter.of(eventoRepository.findAll());

	        if (eventos.isEmpty()) {
	            return ResponseEntity.notFound().build(); 
	        }

	        return ResponseEntity.ok(eventos); 
	    }


	
	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}

	/**
	 * Busca los detalles de un evento por su ID.
	 * 
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
