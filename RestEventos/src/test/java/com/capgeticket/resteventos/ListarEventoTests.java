package com.capgeticket.resteventos;

import com.capgeticket.resteventos.controller.EventoController;
import com.capgeticket.resteventos.error.NoEventosException;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
        evento1.setNombre("Rock in Rio");
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
    void shouldSuccessfullyListEvento() {
        List<Evento> eventos = new ArrayList<>();
        eventos.add(evento1);
        eventos.add(evento2);

        List<EventoResponse> eventoResponses = new ArrayList<>();
        eventoResponses.add(new EventoResponse(evento1.getId(), evento1.getNombre(), evento1.getDescripcion(), evento1.getGenero(),evento1.getFechaEvento(), evento1.getPrecioMin(), evento1.getPrecioMax(), evento1.getLocalidad(), evento1.getRecinto()));
        eventoResponses.add(new EventoResponse(evento2.getId(), evento2.getNombre(), evento2.getDescripcion(), evento2.getGenero(), evento2.getFechaEvento(), evento2.getPrecioMin(), evento2.getPrecioMax(), evento2.getLocalidad(), evento2.getRecinto()));

        when(eventoService.buscarTodos()).thenReturn(eventos);
        when(eventoAdapter.toDTOList(eventos)).thenReturn(eventoResponses);

        List<EventoResponse> response = eventoController.getEventoAll();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(2, response.size());
        assertEquals("Rock in Rio", response.get(0).getNombre());
        assertEquals("Concierto de Jazz", response.get(1).getNombre());

        verify(eventoService, times(1)).buscarTodos();
        verify(eventoAdapter, times(1)).toDTOList(eventos);
    }

    /**
     * Prueba unitaria para verificar que se devuelve un mensaje de error
     * cuando no hay eventos en la base de datos.
     */
    @Test
    void shouldReturnException_NotFound() {
    	when(eventoService.buscarTodos()).thenReturn(Collections.emptyList());
        Exception exception = assertThrows(NoEventosException.class, () -> {
            eventoController.getEventoAll();
        });
        assertEquals("Actualmento no existen datos en la base de datos", exception.getMessage());
    }
    
   
}
