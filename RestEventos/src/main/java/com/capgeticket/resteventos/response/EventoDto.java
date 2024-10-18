package com.capgeticket.resteventos.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class EventoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String descripcion;

	private String genero;

	private LocalDateTime fecha_evento;

	private double precio_min;

	private double precio_max;

	private String localidad;

	private String recinto;

	public EventoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventoDto(Long id, String nombre, String descripcion, String genero, LocalDateTime fecha_evento,
			double precio_min, double precio_max, String localidad, String recinto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.genero = genero;
		this.fecha_evento = fecha_evento;
		this.precio_min = precio_min;
		this.precio_max = precio_max;
		this.localidad = localidad;
		this.recinto = recinto;
	}

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

	@Override
	public String toString() {
		return "EventoDto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", genero=" + genero
				+ ", fecha_evento=" + fecha_evento + ", precio_min=" + precio_min + ", precio_max=" + precio_max
				+ ", localidad=" + localidad + ", recinto=" + recinto + "]";
	}

}
