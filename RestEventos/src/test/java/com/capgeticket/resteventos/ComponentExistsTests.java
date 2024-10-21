package com.capgeticket.resteventos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgeticket.resteventos.controller.EventoController;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.service.EventoService;

@SpringBootTest
class ComponentExistsTest {
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private EventoController eventoController;

	@Autowired
	private EventoRepository eventoRepository;
	
	
	/**
	 * Comprueba que existe el servicio
	 */
	@Test
	void shouldExistService() {
		assertThat(eventoService).isNotNull();
	}
	
	/**
	 * Comprueba que existe el controlador
	 */
	@Test
	void shouldExistController() {
		assertThat(eventoController).isNotNull();
	}
	
	/**
	 * Comprueba que existe el repositorio
	 */
	@Test
	void shouldExistRepository() {
		assertThat(eventoRepository).isNotNull();
	}

}
