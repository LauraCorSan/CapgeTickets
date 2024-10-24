package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: CompraConfirmadaResponse 
 * Descripción: clase dto con los datos más
 * relevantes para devolver y confirmar compra al usuario 
 * Fecha: 23/10/24
 * Versión: 1.0 
 * Autores: Laura Cordero
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraConfirmadaResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mensaje;

	private String nombreEvento;

	private String fecha;

	private double precio;

	private String email;

}
