package com.capgeticket.resteventos.error;

/**
 * Clase: EventoInvalidoException
 * Descripción: excepción personalizada si la creación del evento es errónea
 * Fecha: 21/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio
 */
public class EventoInvalidoException extends RuntimeException{
	  private static final long serialVersionUID = 1L;

	    public EventoInvalidoException(String message) {
	        super("{ \"error\": \"Solicitud incorrecta.\", \"details\": \""+ message+"\" }");
	    }

}
