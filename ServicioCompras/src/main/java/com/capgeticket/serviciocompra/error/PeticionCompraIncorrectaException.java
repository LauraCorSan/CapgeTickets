package com.capgeticket.serviciocompra.error;

/**
 * Clase: PeticionCompraIncorrectaException
 * Descripción: excepción personalizada si los datos al intentar realizar una compra son incorrectos
 * Fecha: 24/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio
 */
public class PeticionCompraIncorrectaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PeticionCompraIncorrectaException(String message) {
		super(message);
	}
	
	

}
