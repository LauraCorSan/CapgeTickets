package com.capgeticket.resteventos.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgeticket.resteventos.model.Evento;

import com.capgeticket.resteventos.response.EventoResponse;


@Component
public class EventoAdapter {
	
	public EventoResponse of(Evento evento) {
		EventoResponse eventoResponse = new EventoResponse();
		eventoResponse.setId(evento.getId());
		eventoResponse.setNombre(evento.getNombre());
		eventoResponse.setDescripcion(evento.getDescripcion());
		eventoResponse.setGenero(evento.getGenero());
		eventoResponse.setFecha_evento(evento.getFecha_evento());
		eventoResponse.setPrecio_min(evento.getPrecio_min());
		eventoResponse.setPrecio_max(evento.getPrecio_max());
		eventoResponse.setLocalidad(evento.getLocalidad());
		eventoResponse.setRecinto(evento.getRecinto());
		

        return eventoResponse;
    }

  

	public List<EventoResponse> of(List<Evento> eventos) {
        return eventos.stream()
                .map(e -> of(e))
                .collect(Collectors.toList());
    }
}