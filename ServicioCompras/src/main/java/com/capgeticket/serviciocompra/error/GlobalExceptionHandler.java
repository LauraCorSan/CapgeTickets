package com.capgeticket.serviciocompra.error;

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
 * Fecha: 24/10/24
 * Versión: 1.0
 * Autores: Laura Cordero
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

//	    @ExceptionHandler(PeticionCompraIncorrectaException.class)
//	    public ResponseEntity<ErrorResponse> handleEventoInvalidoException(PeticionCompraIncorrectaException ex) {
//	        logger.error("Evento inválido: {}", ex.getMessage());
//	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.BAD_REQUEST.value(),"La solicitud es incorrecta. Verifica los datos enviados.",ex.getMessage());
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//	    }
	    
//	    @ExceptionHandler(ReciboCompraIncorrectaException.class)
//	    public ResponseEntity<ErrorResponse> handleEventoNotFoundException(ReciboCompraIncorrectaException ex) {
//	        logger.error("Evento no encontrado: {}", ex.getMessage());
//	        ErrorResponse errorResponse = new ErrorResponse( HttpStatus.NOT_FOUND.value(),"Evento no encontrado",ex.getMessage());
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//	    }
	    

}
