package com.capgeticket.resteventos.controller;

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
	@PutMapping
	public EventoResponse modificarEvento(@PathVariable Long id, @RequestBody Evento evento) {
		//final Evento e = service.findById(id).orElseThrow();
		Evento e = eventoService.aniadirEvento(evento);
        return eventoAdapter.toDTO(e);
	}


	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}

}
