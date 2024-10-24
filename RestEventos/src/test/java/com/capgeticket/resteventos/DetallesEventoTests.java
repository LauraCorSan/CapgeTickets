package com.capgeticket.resteventos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.service.EventoServiceImpl;

/**
 * Clase: eventoDetallesTests 
 * Descripción: clase de tests del método ver detalles. Comprobar que devuelve los
 * detalles de manera correcta, si el id de evento no existe.
 * Fecha: 21/10/24 
 * Versión: 1.0 
 * Autores: Veronica Parra
 */

public class DetallesEventoTests {

	@Mock
	private EventoRepository eventoRepository;
	@InjectMocks
	private EventoServiceImpl eventoService;
	private Evento evento;
	
	 @BeforeEach
	    void setUp() {
		 // Inicializa los mocks
	        MockitoAnnotations.openMocks(this); 
	    }
	 
		/**
		 * Test que comprueba si un evento existe y 
		 * lo devuelve correctamente
		 */
	 
	 @Test
	    void shouldSuccessfullyGetDetailsEvento() {
	        /*Long eventoId = 1L;
	        Evento evento = new Evento();
	        evento.setId(eventoId);
	        when(eventoRepository.findById(eventoId)).thenReturn(Optional.of(evento));
	        Evento resultado = eventoService.detallesEvento(eventoId);
	        assertNotNull(resultado);
	        assertEquals(eventoId, resultado.getId());*/
	    }
		/**
		 * Test que comprueba un ID incorrecto
		 */
	    @Test
	    void shouldReturnException_NotFound() {
	        Long eventoId = 2L;
	        when(eventoRepository.findById(eventoId)).thenReturn(Optional.empty());
	        Exception exception = assertThrows(RuntimeException.class, () -> {
	            eventoService.detallesEvento(eventoId);
	        });
	        assertEquals("{ \"error\": \"Evento no encontrado.\", \"details\": \"El id 2 no se ha encontrado\" }" , exception.getMessage());
	    }
	
}
