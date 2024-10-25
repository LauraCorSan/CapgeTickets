package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: EventoResponse
 * Descripción: clase dto con los datos más relevantes
 * Fecha: 21/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String descripcion;

	private String genero;
	
	private LocalDateTime fechaEvento;

	private double precioMin;

	private double precioMax;

	private String localidad;

	private String recinto;




}
