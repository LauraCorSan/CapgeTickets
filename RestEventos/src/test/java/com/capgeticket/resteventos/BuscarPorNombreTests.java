package com.capgeticket.resteventos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.controller.EventoController;
import com.capgeticket.resteventos.error.EventoNotFoundException;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.service.EventoServiceImpl;

/**
 * Clase: BuscarPorNombreTests
 * Descripción: clase de tests del método de buscarPorNombre, comprueba que se realice correctamente o no se encuentra el evento
 * Fecha: 23/10/24 
 * Versión: 1.0 
 * Autores: Laura Gregorio
 */
@ExtendWith(MockitoExtension.class)  
class BuscarPorNombreTests {
    @Mock
    private EventoServiceImpl eventoService;

    @Mock
    private EventoAdapter eventoAdapter;

    @InjectMocks
    private EventoController eventoController;

    /**
     * Test para verificar que se devuelve 200 OK cuando hay eventos con el nombre dado.
     */
    @Test
    void shouldReturn200OKWhenEventsExist() {
        String nombreEvento = "Noche Flamenca";

        List<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento()); 
        List<EventoResponse> eventoResponses = new ArrayList<>();
        eventoResponses.add(new EventoResponse());

        when(eventoService.buscarPorNombre(nombreEvento)).thenReturn(eventos);
        when(eventoAdapter.toDTOList(eventos)).thenReturn(eventoResponses);

        List<EventoResponse> response = eventoController.listarPorNombre(nombreEvento);

        assertNotNull(response);
        assertFalse(response.isEmpty());

        verify(eventoService, times(1)).buscarPorNombre(nombreEvento);
        verify(eventoAdapter, times(1)).toDTOList(eventos);
    }

    /**
     * Test para verificar que se lanza EventoNotFoundException cuando no hay eventos.
     */
    @Test
    void shouldThrowEventoNotFoundExceptionWhenNoEventsExist() {
        String nombreEvento = "Evento Inexistente";

        when(eventoService.buscarPorNombre(nombreEvento)).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(EventoNotFoundException.class, () -> {
            eventoController.listarPorNombre(nombreEvento);
        });

        assertEquals("{ \"error\": \"Evento no encontrado.\", \"details\": \"No existe ningún evento con el nombre Evento Inexistente\" }" , exception.getMessage());

        verify(eventoService, times(1)).buscarPorNombre(nombreEvento);
    }
	

}
