package com.capgeticket.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;

@FeignClient(name = "banco", url= "http://banco.eu-west-3.elasticbeanstalk.com")
public interface BancoFeignClient {
	
 
	@PostMapping("/pasarela/compra")
	public ReciboCompraResponse comprarTicket(@RequestBody DatosCompraResponse datosCompra);
	

}
