package com.capgeticket.resteventos.error;

/**
 * Clase: EventoNotFoundException
 * Descripción: excepción personalizada si no se encuentra un evento
 * Fecha: 21/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
 */

public class EventoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EventoNotFoundException(String message) {
		super("{ \"error\": \"Evento no encontrado.\", \"details\": \"" + message + "\" }");
	}
}
