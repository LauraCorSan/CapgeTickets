package com.capgeticket.serviciocompra.model;

import java.time.LocalDateTime;

import com.capgeticket.resteventos.model.Evento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Long id_compra;
	
	@ManyToOne
    @JoinColumn(name = "id_evento", nullable = false) 
    private Evento evento;
	
	@Column(name = "precio_compra")
	private double precio;
	
	@Column(name = "fecha_compra")
	private LocalDateTime fecha;
	
	@Column(name = "email")
	private String email;
	
}
