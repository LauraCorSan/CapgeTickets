package com.capgeticket.serviciocompra.service;

import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;

/**

* Interfaz: CompraService
* Descripción: interfaz que define los metodos de la clase de servicio
* Fecha: 24/10/24
* Versión: 2.0
* Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica

 */

public interface CompraService {
	public CompraConfirmadaResponse nuevaCompra(PeticionCompraResponse peticion); 
}
