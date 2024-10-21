package com.capgeticket.resteventos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Clase: OpenApiConfig Descripción: configuración del proyecto en openAPI
 * Fecha: 21/10/24 Versión: 1.0 Autores: Laura Gregorio
 */
@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI StudentOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Gestión de eventos servicio REST").description(
						"Servicio encargado de gestionar eventos, crearlos, consultarlos, eliminarlos y modificarlos.")
						.version("v1.0")
						.contact(new Contact().name("Laura Gregorio, Laura Cordero, Elena, Verónica, Guillermo")
								.url("https://grupo2.es").email("grupo2@capgemini.es"))
						.license(new License().name("LICENSE").url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation().url("https://miproyectoeventos.es"));

	}

}
