package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: ReciboCompraResponse
 * Descripción: clase dto con los datos que nos proporciona el microservicio Banco
 * Fecha: 23/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReciboCompraResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String timestamp;

	private String status;

	private String error;
	
	private List<String> message;
	
	private DatosCompraResponse info;
	
	private String infoadicional;
	
	

}
