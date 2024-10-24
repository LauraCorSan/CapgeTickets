package com.capgeticket.serviciocompra.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: DatosCompraResponse
 * Descripción: clase dto con los datos que se utiliza para comunicarse con el miroservicio banco
 * Fecha: 24/10/24
 * Versión: 1.0
 * Autores: Elena Cantonero
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosCompraResponse implements Serializable {
	
	private String nombreTitular;
	
	private String nombreTarjeta;
	
	private int mesCaducidad;
	
	private int yearCaducidad;
	
	private int cvv;
	
	private String emisor;
	
	private String concepto;
	
	private double cantidad;

}
