package com.capgeticket.resteventos.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.capgeticket.resteventos.model.Evento;

public class EventoResponse implements Serializable {

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

	// Método para convertir un Evento en EventoResponse
    public static EventoResponse of(Evento evento) {
        EventoResponse eventoResponse = new EventoResponse();
        eventoResponse.setId(evento.getId());
        eventoResponse.setNombre(evento.getNombre());
        eventoResponse.setDescripcion(evento.getDescripcion());
        eventoResponse.setGenero(evento.getGenero());
        eventoResponse.setFecha_evento(evento.getFecha_evento());
        eventoResponse.setPrecio_min(evento.getPrecio_min());
        eventoResponse.setPrecio_max(evento.getPrecio_max());
        eventoResponse.setLocalidad(evento.getLocalidad());
        eventoResponse.setRecinto(evento.getRecinto());
        return eventoResponse;
    }

	


	

}
