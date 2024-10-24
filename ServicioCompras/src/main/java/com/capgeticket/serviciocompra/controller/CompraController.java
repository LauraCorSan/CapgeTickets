package com.capgeticket.serviciocompra.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;


/**
 * Clase: CompraController
 * Descripción: clase de control (recepcion y procesamiento) de endpoints
 * Fecha: 24/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio
 */
@RestController
public class CompraController {
	
	
	@PostMapping
	public CompraConfirmadaResponse nuevaCompra(@RequestBody PeticionCompraResponse peticionCompraResponse) {
		return null;
//		if peticionCompraResponse.email is empty throw exception
//		if peticionCompraResponse.idEvento is empty throw exception
//		CompraConfirmadaResponse compraConfirmada = compraService.nuevaCompra(peticionCompraResponse)
//		return compraConfirmada;
	}

}
