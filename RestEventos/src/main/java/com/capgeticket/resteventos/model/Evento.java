package com.capgeticket.resteventos.model;

import java.time.LocalDateTime;

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

	@Column(name = "fecha_evento")
	private LocalDateTime fecha_evento;

	@Column(name = "precio_min")
	private double precio_min;

	@Column(name = "precio_max")
	private double precio_max;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "recinto")
	private String recinto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDateTime getFecha_evento() {
		return fecha_evento;
	}

	public void setFecha_evento(LocalDateTime fecha_evento) {
		this.fecha_evento = fecha_evento;
	}

	public double getPrecio_min() {
		return precio_min;
	}

	public void setPrecio_min(double precio_min) {
		this.precio_min = precio_min;
	}

	public double getPrecio_max() {
		return precio_max;
	}

	public void setPrecio_max(double precio_max) {
		this.precio_max = precio_max;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getRecinto() {
		return recinto;
	}

	public void setRecinto(String recinto) {
		this.recinto = recinto;
	}

	
	
}
