package com.capgeticket.serviciocompra;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgeticket.serviciocompra.controller.CompraController;
import com.capgeticket.serviciocompra.repository.CompraRepository;
import com.capgeticket.serviciocompra.service.CompraService;


@SpringBootTest
class ExistenceComponentsTest {
	
	@Autowired
	private CompraController compraController;
	
	@Autowired
	private CompraService compraService;	

	@Autowired
	private CompraRepository compraRepository;
	
	/**
	 * Comprueba que existe el controlador
	 */
	@Test
	void shouldExistController() {
		assertThat(compraController).isNotNull();
	}
	
	/**
	 * Comprueba que existe el servicio
	 */
	@Test
	void shouldExistService() {
		assertThat(compraService).isNotNull();
	}
	
	/**
	 * Comprueba que existe el repositorio
	 */
	@Test
	void shouldExistRepository() {
		assertThat(compraRepository).isNotNull();
	}

}
