package com.capgeticket.resteventos;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgeticket.resteventos.error.EventoInvalidoException;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.service.EventoServiceImpl;

/**
 * Clase: AniadirEventoTests Descripción: clase de tests del método de añadir
 * evento, comprueba que se realice correctamente, si los datos estan
 * incompletos o si estan incorrectos 
 * Fecha: 21/10/24 
 * Versión: 1.0 
 * Autores: Laura Gregorio
 */
public class AniadirEventoTests {

	@Mock
	private EventoRepository eventoRepository;

	@InjectMocks
	private EventoServiceImpl eventoService;

	private Evento evento;

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
	}

	/**
	 * Test que comprueba si un evento se ha creado correctamente
	 */
	@Test
	public void eventCreatedSuccess() {
		when(eventoRepository.save(evento)).thenReturn(evento);

		Evento result = eventoService.aniadirEvento(evento);

		assertEquals(evento.getId(), result.getId());
		assertEquals(evento.getNombre(), result.getNombre());
		assertEquals(evento.getDescripcion(), result.getDescripcion());
		assertEquals(evento.getGenero(), result.getGenero());
		assertEquals(evento.getFechaEvento(), result.getFechaEvento());
		assertEquals(evento.getPrecioMin(), result.getPrecioMin());
		assertEquals(evento.getPrecioMax(), result.getPrecioMax());
		assertEquals(evento.getLocalidad(), result.getLocalidad());
		assertEquals(evento.getRecinto(), result.getRecinto());
	}

	/**
	 * Test que comprueba si los campos del evento están vacíos salta la excepción correspondiente
	 */
	@Test
	public void incompleteData() {
		evento.setNombre(null);

		EventoInvalidoException exception = assertThrows(EventoInvalidoException.class, () -> {
			eventoService.aniadirEvento(evento);
		});

		assertEquals("{error: El nombre del evento no puede estar vacío. }", exception.getMessage());
	}

	/**
	 * Test que comprueba si los campos del evento son incorrectos salta la excepción correspondiente
	 */
	@Test
	public void invalidaData() {
		evento.setFechaEvento(LocalDateTime.now().minusDays(1));

		EventoInvalidoException exception = assertThrows(EventoInvalidoException.class, () -> {
			eventoService.aniadirEvento(evento);
		});

		assertEquals("{error: La fecha del evento no puede ser en el pasado. }", exception.getMessage());
	}
}
