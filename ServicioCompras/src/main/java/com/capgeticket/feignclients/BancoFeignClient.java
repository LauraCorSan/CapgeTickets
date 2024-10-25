package com.capgeticket.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;

/**
 * Interfaz: BancoFeignClient 
 * Descripción: la interfaz que declara la conexion con el servicio de Banco mediante Feign
 * Fecha: 24/10/24
 * Versión: 1.0 
 * Autores: Veronica
 */
@FeignClient(name = "banco", url= "http://banco.eu-west-3.elasticbeanstalk.com")
public interface BancoFeignClient {
	
	@PostMapping("/pasarela/compra")
<<<<<<< HEAD

	public ReciboCompraResponse comprarTicket(@RequestBody DatosCompraResponse datosCompra);

	
=======
	public ReciboCompraResponse comprarTicket(@RequestBody DatosCompraResponse datosCompra);
>>>>>>> b8b596bf54347eff9c7b5613dee4cd0cd8aa9abc

}
