package com.capgeticket.serviciocompra.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;
import com.capgeticket.serviciocompra.service.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Clase: CompraController Descripción: clase de control (recepcion y
 * procesamiento) de endpoints 
 * Fecha: 24/10/24
 *  Versión: 1.0 
 *  Autores: Laura
 * Gregorio
 */
@RestController
public class CompraController {
	private final CompraService compraService;

	public CompraController(CompraService compraService) {
		this.compraService = compraService;
	}
	/**
	 * Crea una nueva compra 
	 *
	 * @param  Un objeto de tipo Compra en formato json con los detalles de la compra confirmada.
	 * @return Un objeto dto
	 */
	@Operation(summary = "Crear una nueva compra", description = "Crea una nueva compra con la información proporcionada.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Compra creada correctamente."),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida.") })
	@PostMapping("/nuevaCompra")
	@ResponseStatus(HttpStatus.CREATED)
	public CompraConfirmadaResponse nuevaCompra(@RequestBody PeticionCompraResponse peticionCompraResponse) {
		CompraConfirmadaResponse compraConfirmada = compraService.nuevaCompra(peticionCompraResponse);
		return compraConfirmada;
	}

}