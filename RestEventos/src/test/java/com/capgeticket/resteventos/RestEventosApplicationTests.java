package com.capgeticket.resteventos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.service.EventoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
public class RestEventosApplicationTests {

	 @Mock
	    private EventoRepository eventoRepository;

	    @InjectMocks
	    private EventoServiceImpl eventoService;

	    private Evento evento;

	    @BeforeEach
	    public void setUp() {
	        evento = new Evento();
	        evento.setId(1L);
	        evento.setNombre("Pau");
	        evento.setDescripcion("concierto anonimo");
	        evento.setGenero("Rock");
	        evento.setFecha_evento(LocalDateTime.now().plusDays(1));
	        evento.setPrecio_min(90.0);
	        evento.setPrecio_max(5000.0);
	        evento.setLocalidad("Murcia");
	        evento.setRecinto("Ayuntamiento");
	    }

	    @Test
	    public void eventDeletedSuccess() {
	        when(eventoRepository.findById(evento.getId())).thenReturn(Optional.of(evento));

	        doNothing().when(eventoRepository).delete(evento);

	        Evento result = eventoService.eliminarEvento(evento);

	        assertEquals(evento.getId(), result.getId());
	        assertEquals(evento.getNombre(), result.getNombre());
	    }

	}