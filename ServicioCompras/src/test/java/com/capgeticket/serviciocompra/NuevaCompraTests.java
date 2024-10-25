package com.capgeticket.serviciocompra;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.capgeticket.serviciocompra.response.PeticionCompraResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.core.MediaType;

/**
 * Clase: NuevaCompraTests Descripción: clase de tests del método de nuevaCompra,
 * Fecha: 25/10/24 
 * Versión: 1.0 
 * Autores: Laura Gregorio
 */
@SpringBootTest
@AutoConfigureMockMvc
class NuevaCompraTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void shouldSuccessfullyAddCompra() throws Exception {
		PeticionCompraResponse peticionCompraResponse = new PeticionCompraResponse();
		peticionCompraResponse.setEmail("usuario@example.com");
		peticionCompraResponse.setIdEvento(6L);
		peticionCompraResponse.setNumeroTarjeta("4444-4444-4444-4444r");
		peticionCompraResponse.setMesCaducidad(12);
		peticionCompraResponse.setYearCaducidad(2025);
		peticionCompraResponse.setCvv(123);
		peticionCompraResponse.setEmisor("VISA");

		String peticionCompraJson = objectMapper.writeValueAsString(peticionCompraResponse);

		mockMvc.perform(post("/nuevaCompra").contentType(MediaType.APPLICATION_JSON).content(peticionCompraJson))
				.andExpect(status().isCreated());
	}
}
