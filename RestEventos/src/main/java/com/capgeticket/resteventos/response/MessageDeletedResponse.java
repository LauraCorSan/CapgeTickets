package com.capgeticket.resteventos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: MessageDeletedResponse 
 * Descripción: clase dto para recibir que se borro todo
 * Fecha: 28/10/24
 * Versión: 1.0 
 * Autores: Laura Cordero
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDeletedResponse {
	private int status;
	private String message;
	private String details;
}
