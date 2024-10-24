package com.capgeticket.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgeticket.resteventos.response.EventoResponse;

@FeignClient(name = "eventos", url= "http://localhost:8080")
public interface EventosFeignClient {
	

    @GetMapping("/evento/{id}")
    public EventoResponse obtenerEventoPorId(@PathVariable Long id);

}
