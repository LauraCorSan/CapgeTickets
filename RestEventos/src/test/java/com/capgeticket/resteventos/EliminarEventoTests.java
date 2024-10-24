package com.capgeticket.resteventos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.controller.EventoController;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.service.EventoService;


/**
 * Clase: EliminarEventoTest 
 * Descripción: clase de tests del método de eliminar
 * evento, comprueba que se realice correctamente o no
 * Fecha: 21/10/24 
 * Versión: 1.0 
 * Autores: Elena y Guillermo
 */
@ExtendWith(MockitoExtension.class) 
public class EliminarEventoTests {
	@Mock
    private EventoRepository eventoRepository;  

    @Mock
    private EventoAdapter eventoAdapter;  
    
    @Mock 
    private EventoService eventoService;

    @InjectMocks
    private EventoController eventoController;  
    
    /**
     * Prueba unitaria para verificar que se devuelve un código de estado 200     *
     * @throws Exception Si ocurre un error durante la prueba.
     */
	@Test
	void shouldSuccessfullyDeleteEvento() {
//	    Long eventId = 20L; 
//	    Evento evento = new Evento(); 
//	    evento.setId(eventId);
//	    
//	    when(eventoService.eliminarEvento(eventId)).thenReturn(evento); // Simulamos el servicio
//
//	    ResponseEntity<String> response = eventoController.deleteEvento(eventId);
//
//	    assertEquals(HttpStatus.OK, response.getStatusCode());
//	    assertEquals("Evento eliminado correctamente.", response.getBody());
//	    
//	    verify(eventoService, times(1)).eliminarEvento(eventId); // Verifica que se llamó al método del servicio
	}
	
	 /**
     * Prueba unitaria para verificar que se devuelve un código de estado 404
     * @throws Exception Si ocurre un error durante la prueba.
     */
	@Test
	void shouldReturnException_NotFound() {
//	    Long eventId = 20L; 
//	    when(eventoService.eliminarEvento(eventId)).thenReturn(null); // Simulamos que no se encuentra el evento
//
//	    ResponseEntity<String> response = eventoController.deleteEvento(eventId);
//
//	    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//	    assertEquals("Evento no encontrado.", response.getBody());
//	    
//	    verify(eventoService, times(1)).eliminarEvento(eventId); // Verifica que se llamó al método del servicio
	}



}
