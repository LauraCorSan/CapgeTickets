package com.capgeticket.resteventos.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.model.Evento;

@RestController
@RequestMapping("/evento")
public class EventoController {
	EventoService service;

	// Editar Usuarios
	@PutMapping
	public void editUser(@RequestBody Evento evento) {
		service.save(evento);
	}
}
