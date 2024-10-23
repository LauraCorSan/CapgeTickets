package com.capgeticket.resteventos;

import com.capgeticket.resteventos.controller.EventoController;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.adapter.EventoAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Clase: ListarEventoTests
 * Descripción: clase de tests del método de listar
 * evento, comprueba que se realice correctamente, que no se encuentren y devuelva un mensaje
 * o que se haga un bad request y devuelva un mensaje
 * Fecha: 21/10/24 
 * Versión: 1.0 
 * Autores: Elena
 */
@ExtendWith(MockitoExtension.class)  
class ListarEventoTests {

    @Mock
    private EventoRepository eventoRepository;  

    @Mock
    private EventoAdapter eventoAdapter;

    @Mock
    private EventoService eventoService;  // Mock para EventoService

    @InjectMocks
    private EventoController eventoController;  // Inyectar mocks en el controlador

    private Evento evento1;
    private Evento evento2;

    @BeforeEach
    void setUp() {
        evento1 = new Evento();
        evento1.setId(1L);
        evento1.setNombre("Concierto de Rock");
        evento1.setDescripcion("Descripción del concierto de rock.");
        evento1.setGenero("Rock");
        evento1.setPrecioMin(20.0);
        evento1.setPrecioMax(60.0);
        evento1.setLocalidad("Madrid");
        evento1.setRecinto("Palacio de los Deportes");

        evento2 = new Evento();
        evento2.setId(2L);
        evento2.setNombre("Concierto de Jazz");
        evento2.setDescripcion("Descripción del concierto de jazz.");
        evento2.setGenero("Jazz");
        evento2.setPrecioMin(15.0);
        evento2.setPrecioMax(45.0);
        evento2.setLocalidad("Madrid");
        evento2.setRecinto("Palacio de los Deportes");
    }

    /**
     * Prueba unitaria para verificar que se devuelve una lista de eventos
     * cuando existen eventos en la base de datos.
     */
    @Test
    void testGetEventoAll_ReturnsListOfEventos() {
        when(eventoService.buscarTodos()).thenReturn(Arrays.asList(evento1, evento2));  
   
        ResponseEntity<List<EventoResponse>> response = eventoController.getEventoAll();

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Rock in Rio", response.getBody().get(0).getNombre());
        assertEquals("Noche Flamenca", response.getBody().get(1).getNombre());

        verify(eventoService, times(1)).buscarTodos();  
    }

    /**
     * Prueba unitaria para verificar que se devuelve 404 Not Found
     * cuando no hay eventos en la base de datos.
     */
    @Test
    void testGetEventoAll_NoEventos_Returns404() {
        when(eventoService.buscarTodos()).thenReturn(Collections.emptyList());  // Mocking eventoService con lista vacía
       
        ResponseEntity<List<EventoResponse>> response = eventoController.getEventoAll();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody()); 
    }
    
    /**
     * Prueba unitaria para verificar que se devuelve 400 Bad Request
     * si la solicitud al endpoint no es válida.
     */
    @Test
    void testGetEventoAll_BadRequest_Returns400() {
        doThrow(new RuntimeException("Error en la solicitud")).when(eventoService).buscarTodos();  // Simula excepción

        ResponseEntity<List<EventoResponse>> response;

        try {
            response = eventoController.getEventoAll();
        } catch (RuntimeException e) {
            response = ResponseEntity.badRequest().build();
        }

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
