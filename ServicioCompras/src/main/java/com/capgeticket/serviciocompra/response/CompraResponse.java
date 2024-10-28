package com.capgeticket.serviciocompra.response;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: CompraResponse Descripción: clase dto con los datos de Compra
 * Fecha: 23/10/24 Versión: 1.0 Autores: Guillermo Garcia
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idEvento;
	private double precio;
	private String email;
	private String fecha;
}