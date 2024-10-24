package com.capgeticket.serviciocompra.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.capgeticket.resteventos.error.ErrorResponse;

/**
 * Clase: GlobalExceptionHandler
 * Descripción: gestionar excepciones customizadas
 * Fecha: 24/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	    @ExceptionHandler(PeticionCompraIncorrectaException.class)
	    public ResponseEntity<ErrorResponse> handlePeticionCompraIncorrectaException(PeticionCompraIncorrectaException ex) {
	        logger.error("Peticion de compra inválida: {}", ex.getMessage());
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.BAD_REQUEST.value(),"La solicitud es incorrecta. Verifica los datos enviados.",ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
	    
	    @ExceptionHandler(ReciboCompraIncorrectaException.class)
	    public ResponseEntity<ErrorResponse> handleReciboCompraIncorrectaException(ReciboCompraIncorrectaException ex) {
	        logger.error("Intento de compra fallido: {}", ex.getMessage());
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.BAD_REQUEST.value(),"Intento de compra fallido",ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
	    
	    @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<ErrorResponse> handleRouteNotFoundException(NoHandlerFoundException ex) {
	        logger.error("La ruta solicitada no existe: " + ex.getRequestURL());
	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.NOT_FOUND.value(),"La ruta solicitada no existe",ex.getMessage());
	        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	    }
	    

}
