package com.capgeticket.resteventos.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgeticket.resteventos.model.Evento;

@Component
public class EventoDto {
	public EventoDto of(Evento evento) {
		EventoDto eventoDto = new EventoDto();
		eventoDto.setId(evento.getId());
		eventoDto.setNombre(evento.getNombre());
		eventoDto.setDescripcion(evento.getDescripcion());
		eventoDto.setGenero(evento.getGenero());
		eventoDto.setFecha_evento(evento.getFecha_evento());
		eventoDto.setPrecio_min(evento.getPrecio_min());
		eventoDto.setPrecio_max(evento.getPrecio_max());
		eventoDto.setLocalidad(evento.getLocalidad());
		eventoDto.setRecinto(evento.getRecinto());
		
        return eventoDto;
    }

    public List<EventoDto> of(List<Evento> eventos) {
        return eventos.stream()
                .map(e -> of(e))
                .collect(Collectors.toList());
    }
}