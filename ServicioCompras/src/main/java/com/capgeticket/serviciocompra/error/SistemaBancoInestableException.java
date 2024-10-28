package com.capgeticket.serviciocompra.error;

/**
 * Clase: SistemaBancoInestableException
 * Descripción: excepción personalizada si la respuesta de el servivio banco es 500 ya que cae
 * Fecha: 28/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
 */
public class SistemaBancoInestableException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public SistemaBancoInestableException (String message) {
		super(message);
	}


}
