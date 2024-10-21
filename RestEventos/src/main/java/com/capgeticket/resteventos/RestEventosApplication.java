package com.capgeticket.resteventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* Clase: RestEventosApplication
* Descripción: clase con main que ejecuta la aplicacion 
* Fecha: 18/10/24
* Versión: 1.0
* Autores: 
*/

@SpringBootApplication
@EnableDiscoveryClient
public class RestEventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEventosApplication.class, args);
	}

}
