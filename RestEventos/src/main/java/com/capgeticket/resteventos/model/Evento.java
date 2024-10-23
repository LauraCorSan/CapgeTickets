package com.capgeticket.resteventos.model;

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
@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "genero")
	private String genero;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "fecha_evento")
    private LocalDateTime fechaEvento;

	@Column(name = "precio_min")
	private double precioMin;

	@Column(name = "precio_max")
	private double precioMax;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "recinto")
	private String recinto;

}
