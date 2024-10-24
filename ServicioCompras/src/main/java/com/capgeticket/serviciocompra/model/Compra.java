package com.capgeticket.serviciocompra.model;
import java.io.Serializable;
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
import lombok.Builder;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "compra")
public class Compra  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private Long idCompra;
	
	@Column(name = "id_evento", nullable = false) 
    private Long idEvento;
	
	@Column(name = "precio_evento")
	private double precio;
	
	@Column(name = "fecha_compra")
	private String fecha;
	
	@Column(name = "email")
	private String email;
	
}
