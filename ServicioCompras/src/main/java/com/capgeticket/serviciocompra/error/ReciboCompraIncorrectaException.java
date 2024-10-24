package com.capgeticket.serviciocompra.error;


/**
 * Clase: ReciboCompraIncorrectaException
 * Descripción: excepción personalizada si la respuesta del intento de compra devuelve error
 * Fecha: 24/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio
 */
public class ReciboCompraIncorrectaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ReciboCompraIncorrectaException(String message) {
		super(message);
	}


}
