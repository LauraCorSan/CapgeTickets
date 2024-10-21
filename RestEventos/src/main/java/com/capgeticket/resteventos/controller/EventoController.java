package com.capgeticket.resteventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired EventoRepository eventoRepository;
	
	 @Autowired
	    private EventoAdapter eventoAdapter;
	
	@GetMapping("/")
	 public List<EventoResponse> getEventoAll() {
        // Usa el adapter para convertir la lista de eventos
        return eventoAdapter.of(eventoRepository.findAll());
    }

}
