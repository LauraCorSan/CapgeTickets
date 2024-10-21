package com.capgeticket.resteventos.error;

/**
 * Clase: EventoNotFound
 * Descripción: excepción personalizada si no se encuentra un evento
 * Fecha: 21/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio y Laura Cordero
 */
public class EventoNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EventoNotFound() {
		super("Evento no encontrado! D:");
	}

	public EventoNotFound(Long id) {
		super("Evento con id " + id + " no encontrado! D:");
	}

}
