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
	    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
	        logger.error("Ocurrió un error: {}", ex.getMessage()); 
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.INTERNAL_SERVER_ERROR.value(),"Error en el servidor","Ha ocurrido un error en el servidor, vuelva a intentarlo más tarde");
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }

	    @ExceptionHandler(EventoInvalidoException.class)
	    public ResponseEntity<ErrorResponse> handleEventoInvalidoException(EventoInvalidoException ex) {
	        logger.error("Evento inválido: {}", ex.getMessage());
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.BAD_REQUEST.value(),"La solicitud es incorrecta. Verifica los datos enviados.",ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
	    
	    @ExceptionHandler(EventoNotFoundException.class)
	    public ResponseEntity<ErrorResponse> handleEventoNotFoundException(EventoNotFoundException ex) {
	        logger.error("Evento no encontrado: {}", ex.getMessage());
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.NOT_FOUND.value(),"Evento no encontrado",ex.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	    }
	    
	    @ExceptionHandler(NoEventosException.class)
	    public ResponseEntity<ErrorResponse> handleNoEventosException(NoEventosException ex) {
	        logger.error("No hay eventos: {}", ex.getMessage());
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.NO_CONTENT.value(),"No existen datos",ex.getMessage());
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
	    }
	    
	    @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex) {
	        String error = "La ruta solicitada no existe: " + ex.getRequestURL();
	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	    }

}