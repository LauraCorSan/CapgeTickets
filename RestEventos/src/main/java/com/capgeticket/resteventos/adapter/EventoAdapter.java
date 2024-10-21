package com.capgeticket.resteventos.adapter;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgeticket.resteventos.model.Evento;

import com.capgeticket.resteventos.response.EventoResponse;

/**
 * Clase: EventoAdapter
 * Descripción: contiene métodos que convierten un objeto/s Evento a EventoResponse
 * Fecha: 21/10/24
 * Versión: 1.0
 * Autores: Elena Cantonero y Laura Gregorio
 */
@Component
public class EventoAdapter {
	
	/**
	 * Convierte un objeto Evento en un objeto EventoResponse.
	 *
	 * @param evento El objeto Evento que se va a convertir.
	 * @return El objeto EventoResponse resultante.
	 */
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
    

   /**
     * Convierte una lista de objetos Evento en una lista de objetos EventoResponse.
     *
     * @param eventos La lista de objetos Evento que se van a convertir.
     * @return Una lista de objetos EventoResponse resultantes.
     */
    public List<EventoResponse> of(List<Evento> eventos) {
        return eventos.stream()
                .map(this::of)  // Usa el método 'of' para cada Evento
                .collect(Collectors.toList());
    }


	public EventoResponse toDTO(Evento evento) {
		return EventoResponse.builder().id(evento.getId()).nombre(evento.getNombre())
				.descripcion(evento.getDescripcion()).genero(evento.getGenero()).fecha_evento(evento.getFecha_evento())
				.precio_min(evento.getPrecio_min()).precio_max(evento.getPrecio_max()).localidad(evento.getLocalidad())
				.recinto(evento.getRecinto()).build();
	}

	public List<EventoResponse> toDTOList(List<Evento> eventos) {
		return eventos.stream().map(this::toDTO).collect(Collectors.toList());
	}

}