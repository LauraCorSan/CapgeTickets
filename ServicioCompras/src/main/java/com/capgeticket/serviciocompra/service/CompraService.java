package com.capgeticket.serviciocompra.service;

import java.time.LocalDateTime;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.serviciocompra.model.Compra;

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

/**

* Interfaz: CompraService
* Descripción: interfaz que define los metodos de la clase de servicio
* Fecha: 24/10/24
* Versión: 2.0
* Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica

 */

public interface CompraService {
	
	public Compra nuevaCompra(Compra compra);
	
}
