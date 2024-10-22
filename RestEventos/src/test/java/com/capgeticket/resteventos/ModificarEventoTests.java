package com.capgeticket.resteventos;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.controller.EventoController;
import com.capgeticket.resteventos.error.EventoInvalidoException;
import com.capgeticket.resteventos.error.EventoNotFoundException;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.resteventos.service.EventoServiceImpl;

class ModificarEventoTests {

	@Mock
	private EventoRepository eventoRepository;

	@Mock
	private EventoServiceImpl eventoService;

	@Mock
	private EventoAdapter eventoAdapter;

	@InjectMocks
	private EventoController eventoController;

	private Evento evento;
	private EventoResponse eventoMod;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);

		evento = new Evento();
		evento.setId(1L);
		evento.setNombre("Concierto");
		evento.setDescripcion("Concierto de rock.");
		evento.setGenero("Rock");
		evento.setFechaEvento(LocalDateTime.now().plusDays(1));
		evento.setPrecioMin(10.0);
		evento.setPrecioMax(50.0);
		evento.setLocalidad("Madrid");
		evento.setRecinto("Palacio de los Deportes");

		eventoMod = new EventoResponse();
		eventoMod.setNombre("Musical Rey Leon");
		eventoMod.setDescripcion("Un musical");
		eventoMod.setGenero("Musical");
		eventoMod.setFechaEvento(LocalDateTime.now().plusDays(1));
		eventoMod.setPrecioMin(10.0);
		eventoMod.setPrecioMax(50.0);
		eventoMod.setLocalidad("Madrid");
		eventoMod.setRecinto("Teatro Gran Via");
	}

	@Test
	public void eventModifiedSuccess() {
		when(eventoService.buscarPorId(evento.getId())).thenReturn(Optional.of(evento));

		when(eventoAdapter.toEntity(eventoMod)).thenReturn(evento);

		when(eventoService.aniadirEvento(evento)).thenReturn(evento);

		when(eventoAdapter.toDTO(evento)).thenReturn(eventoMod);

		EventoResponse result = eventoController.modificarEvento(evento.getId(), eventoMod);

		assertEquals(evento.getId(), result.getId());
		assertNotEquals(evento.getNombre(), result.getNombre());
		assertNotEquals(evento.getDescripcion(), result.getDescripcion());
		assertNotEquals(evento.getGenero(), result.getGenero());
		assertEquals(evento.getFechaEvento(), result.getFechaEvento());
		assertEquals(evento.getPrecioMin(), result.getPrecioMin());
		assertEquals(evento.getPrecioMax(), result.getPrecioMax());
		assertEquals(evento.getLocalidad(), result.getLocalidad());
		assertNotEquals(evento.getRecinto(), result.getRecinto());
	}

	@Test
	public void notFoundEvento() {
		Long id = 1234L;

		when(eventoService.buscarPorId(id)).thenReturn(Optional.empty());

		EventoNotFoundException exception = assertThrows(EventoNotFoundException.class, () -> {
			eventoController.modificarEvento(id, eventoMod);
		});

		assertEquals("{ \"error\": \"Evento no encontrado.\", \"details\": \"El id 1234 no se ha encontrado\" }",
				exception.getMessage());
	}

	@Test
	public void incompleteData() {
	    when(eventoService.buscarPorId(evento.getId())).thenReturn(Optional.of(evento));
	    
	    eventoMod.setNombre(null);
	    
	    when(eventoAdapter.toEntity(eventoMod)).thenReturn(evento);
	    
	    when(eventoService.aniadirEvento(evento)).thenThrow(new EventoInvalidoException("El nombre del evento no puede estar vacío."));
	    
	    EventoInvalidoException exception = assertThrows(EventoInvalidoException.class, () -> {
	        eventoController.modificarEvento(evento.getId(), eventoMod);
	    });

	    assertEquals("{ \"error\": \"Solicitud incorrecta.\", \"details\": \"El nombre del evento no puede estar vacío.\" }", exception.getMessage());
	}
	
	
	
}
