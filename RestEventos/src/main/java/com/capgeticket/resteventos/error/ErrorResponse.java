package com.capgeticket.resteventos.error;
/**
 * Clase: ErrorResponse 
 * Descripción: modelo de respuesta de error
 * Fecha: 23/10/24
 * Versión: 1.0 
 * Autores: Laura Cordero
 */
public class ErrorResponse {
	private int status;
	private String error;
	private String details;

	public ErrorResponse(int status, String error, String details) {
		this.status = status;
		this.error = error;
		this.details = details;
	}

	// Getters y Setters
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
