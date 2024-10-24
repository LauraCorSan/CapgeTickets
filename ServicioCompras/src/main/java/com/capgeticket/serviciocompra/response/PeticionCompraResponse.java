package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase: PeticionCompraResponse
 * Descripción: clase dto con los datos que nos proporciona el usuario en postman
 * Fecha: 23/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeticionCompraResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	private Long idEvento;

	private String numTarjeta;
	
	private int mesCaducidad;
	
	private int yearCaducidad;
	
	private int cvv;
	
	private String emisor;

}
