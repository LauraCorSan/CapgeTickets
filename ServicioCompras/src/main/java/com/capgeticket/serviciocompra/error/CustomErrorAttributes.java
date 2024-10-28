package com.capgeticket.serviciocompra.error;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.capgeticket.serviciocompra.controller.CompraController;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;


@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {
	
	private static final Logger logger = LoggerFactory.getLogger(CompraController.class);

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
