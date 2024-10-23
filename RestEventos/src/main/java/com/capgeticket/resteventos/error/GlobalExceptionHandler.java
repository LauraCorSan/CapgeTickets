package com.capgeticket.resteventos.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Clase: GlobalExceptionHandler
 * Descripción: gestionar excepciones customizadas
 * Fecha: 21/10/24
 * Versión: 1.0
 * Autores: Laura Gregorio y Laura Cordero
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	    @ExceptionHandler(Exception.class) 
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        logger.error("Ocurrió un error: {}", ex.getMessage()); 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error en el servidor.");
	    }

	    @ExceptionHandler(EventoInvalidoException.class)
	    public ResponseEntity<String> handleEventoInvalidoException(EventoInvalidoException ex) {
	        logger.error("Evento inválido: {}", ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }
	    
	    @ExceptionHandler(EventoNotFoundException.class)
	    public ResponseEntity<String> handleEventoNotFoundException(EventoNotFoundException ex) {
	        logger.error("Evento inválido: {}", ex.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	    
	    @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex) {
	        String error = "La ruta solicitada no existe: " + ex.getRequestURL();
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }

}