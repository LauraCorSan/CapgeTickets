package com.capgeticket.resteventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.resteventos.service.EventoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@Autowired
	EventoAdapter eventoAdapter;

	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}

}
