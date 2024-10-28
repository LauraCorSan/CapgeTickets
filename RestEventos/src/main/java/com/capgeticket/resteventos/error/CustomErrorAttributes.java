package com.capgeticket.resteventos.error;

import org.springframework.stereotype.Component;

import org.springframework.web.context.request.WebRequest;

import com.capgeticket.resteventos.controller.EventoController;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;

/**
 * Clase: CustomErrorAttributes
 * Descripción: clase que edita los parametros que muestra el error
 * Fecha: 28/10/24
 * Versión: 1.0 
 * Autores: Laura Cordero
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
	
	private static final Logger logger = LoggerFactory.getLogger(EventoController.class);

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
		logger.info("------ getErrorAttributes(): " + options);
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
		logger.info("------ getErrorAttributes(): " + options);		

		// Eliminamos la traza para simplificar la salida
		errorAttributes.remove("trace");		

		return errorAttributes;
	}

}
