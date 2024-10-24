package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
<<<<<<< HEAD
 * Clase: Evento 
 * Descripción: modelo Evento con sus atributos 
 * Fecha: 21/10/24
 * Versión: 1.0 
=======
 * Clase: EventoResponse
 * Descripción: clase dto con los datos más relevantes
 * Fecha: 21/10/24
 * Versión: 1.0
>>>>>>> 435c4a2ab9dbd904e9d56c5d7277ff9b3f7a9684
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
