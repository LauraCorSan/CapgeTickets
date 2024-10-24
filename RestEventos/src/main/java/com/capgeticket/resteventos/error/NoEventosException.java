package com.capgeticket.resteventos.error;

/**
 * Clase: NoEventosException
 * Descripción: excepción personalizada si la base de datos esta vacia
 * Fecha: 23/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
 */
public class NoEventosException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoEventosException(String message) {
		super(message);
	}

	
}
