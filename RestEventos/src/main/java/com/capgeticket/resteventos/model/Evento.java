package com.capgeticket.resteventos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Descripcion")
	private String descripcion;
	
	@Column(name = "genero")
	private String genero;
	
	@Column(name = "Fecha evento")
	private LocalDateTime fecha_evento;
	
	@Column(name = "Precio minimo")
	private double precio_min;
	
	@Column(name = "Precio maximo")
	private double precio_max; 
	
	@Column(name = "Localidad")
	private String localidad;
	
	@Column(name = "Recinto")
	private String recinto;
	
	public Evento(Long id, String nombre, String descripcion, String genero, LocalDateTime fecha_evento,
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


	public Evento() {
		super();
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
		return "Evento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", genero=" + genero
				+ ", fecha_evento=" + fecha_evento + ", precio_min=" + precio_min + ", precio_max=" + precio_max
				+ ", localidad=" + localidad + ", recinto=" + recinto + "]";
	}
	
	
	
	

}
