package com.capgeticket.resteventos.adapter;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgeticket.resteventos.model.Evento;

import com.capgeticket.resteventos.response.EventoResponse;

/**
 * Clase: EventoAdapter Descripción: contiene métodos que convierten un objeto/s
 * Evento a EventoResponse Fecha: 21/10/24 Versión: 1.0 Autores: Elena Cantonero
 * y Laura Gregorio
 */
@Component
public class EventoAdapter {

	/**
	 * Convierte un objeto Evento en un objeto EventoResponse.
	 *
	 * @param evento El objeto Evento que se va a convertir.
	 * @return El objeto EventoResponse resultante.
	 */
	public EventoResponse toDTO(Evento evento) {
		return EventoResponse.builder().id(evento.getId()).nombre(evento.getNombre())
				.descripcion(evento.getDescripcion()).genero(evento.getGenero()).fechaEvento(evento.getFechaEvento())
				.precioMin(evento.getPrecioMin()).precioMax(evento.getPrecioMax()).localidad(evento.getLocalidad())
				.recinto(evento.getRecinto()).build();
	}

	/**
	 * Convierte una lista de objetos Evento en una lista de objetos EventoResponse.
	 *
	 * @param eventos La lista de objetos Evento que se van a convertir.
	 * @return Una lista de objetos EventoResponse resultantes.
	 */
	public List<EventoResponse> toDTOList(List<Evento> eventos) {
		return eventos.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public Evento toEntity(EventoResponse eventoDto) {
		return Evento.builder().id(eventoDto.getId()).nombre(eventoDto.getNombre())
				.descripcion(eventoDto.getDescripcion()).genero(eventoDto.getGenero())
				.fechaEvento(eventoDto.getFechaEvento()).precioMin(eventoDto.getPrecioMin())
				.precioMax(eventoDto.getPrecioMax()).localidad(eventoDto.getLocalidad())
				.recinto(eventoDto.getRecinto()).build();
	}

}