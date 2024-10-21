package com.capgeticket.resteventos;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
		evento.setPrecioMax(10.0);
		evento.setPrecioMax(50.0);
		evento.setLocalidad("Madrid");
		evento.setRecinto("Palacio de los Deportes");
		
		eventoMod = new EventoResponse();
		evento.setNombre("Musical Rey Leon");
		evento.setDescripcion("Un musical");
		evento.setGenero("Musical");
		evento.setFechaEvento(LocalDateTime.now().plusDays(1));
		evento.setPrecioMax(10.0);
		evento.setPrecioMax(50.0);
		evento.setLocalidad("Madrid");
		evento.setRecinto("Teatro Gran Via");
	}

	@Test
	public void eventCreatedSuccess() {
		when(eventoService.aniadirEvento(evento)).thenReturn(evento);

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
		when(eventoService.aniadirEvento(evento)).thenReturn(evento);
		Long id=1234L;

		EventoNotFoundException exception = assertThrows(EventoNotFoundException.class, () -> {
			eventoController.modificarEvento(id, eventoMod);
		});

		assertEquals("El id 1234 no se ha encontrado", exception.getMessage());
	}
	

	@Test
	public void incompleteData() {
		when(eventoService.aniadirEvento(evento)).thenReturn(evento);
		eventoMod.setNombre(null);

		EventoInvalidoException exception = assertThrows(EventoInvalidoException.class, () -> {
			eventoController.modificarEvento(evento.getId(), eventoMod);
		});

		assertEquals("El nombre del evento no puede estar vacío.", exception.getMessage());
	}

	@Test
	public void invalidaData() {
		when(eventoService.aniadirEvento(evento)).thenReturn(evento);
		eventoMod.setFechaEvento(LocalDateTime.now().minusDays(1));

		EventoInvalidoException exception = assertThrows(EventoInvalidoException.class, () -> {
			eventoController.modificarEvento(evento.getId(), eventoMod);
		});

		assertEquals("La fecha del evento no puede ser en el pasado.", exception.getMessage());
	}

}
