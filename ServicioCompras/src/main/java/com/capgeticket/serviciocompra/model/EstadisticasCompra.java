package com.capgeticket.serviciocompra.model;

import java.io.Serializable;
import java.time.LocalDate;
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
 * Clase: EstadisticasCompra 
 * Descripción: entidad de estadisticas de compra segun evento por dia 
 * Fecha: 24/10/24 
 * Versión: 1.0 
 * Autores: Laura Cordero
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "estadisticas")
public class EstadisticasCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_evento", nullable = false) 
    private Long idEvento;
	
	@Column(name = "precio_medio")
	private double precioMedio;
	
	@Column(name = "timestamp")
	private LocalDate diaActual;
	
}
