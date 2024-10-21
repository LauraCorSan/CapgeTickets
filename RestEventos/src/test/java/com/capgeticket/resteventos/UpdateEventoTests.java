package com.capgeticket.resteventos;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.controller.EventoController;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.service.EventoService;

@WebMvcTest(EventoController.class)
class UpdateEventoTests {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private EventoService eventoService;

	@Mock
	private EventoAdapter eventoAdapter;

	@InjectMocks
	private EventoController eventoController;

	private Evento evento;

	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        evento = new Evento(1L, "Concierto de Jazz", "Descripción", "Música", 
                             LocalDateTime.now(), 25.00, 75.00, "Barcelona", "Teatro Gran Via");
    }

}
