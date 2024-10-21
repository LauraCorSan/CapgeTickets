package com.capgeticket.resteventos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.adapter.EventoAdapter;

import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.resteventos.service.EventoService;


@RestController
@RequestMapping("/evento")
public class EventoController {
	
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
