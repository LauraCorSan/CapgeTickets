package com.capgeticket.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "banco", url= "http://banco.eu-west-3.elasticbeanstalk.com")
public interface BancoFeignClient {
	
 
	@PostMapping("/")
	public ReciboResponse comprarTicket(@PathVariable)
	

}
