package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: Evento 
 * Descripción: modelo Evento con sus atributos 
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime fechaEvento;

	private double precioMin;

	private double precioMax;

	private String localidad;

	private String recinto;

}
