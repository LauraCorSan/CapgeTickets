package com.capgeticket.serviciocompra;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
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

    PeticionCompraResponse peticionCompra;
    
    DatosCompraResponse datosCompra;

    @BeforeEach
    public void setUp() {
        peticionCompra = new PeticionCompraResponse();
        peticionCompra.setEmail("usuario@example.com");
        peticionCompra.setIdEvento(6L);
        peticionCompra.setNumeroTarjeta("4444-4444-4444-4444");
        peticionCompra.setMesCaducidad(12);
        peticionCompra.setYearCaducidad(2025);
        peticionCompra.setCvv(123);
        peticionCompra.setEmisor("VISA");
    }

    @Test
    public void shouldSuccessfullyAddCompra() throws Exception {
        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnException_InvalidEmail() throws Exception {
        peticionCompra.setEmail("usuarioexample"); 

        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("La solicitud es incorrecta. Verifica los datos enviados."))
                .andExpect(jsonPath("$.details").value("El email tiene un formato incorrecto."));
    }

    @Test
    public void shouldReturnException_InvalidEvento() throws Exception {
        peticionCompra.setIdEvento(0L); 
        
        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("La solicitud es incorrecta. Verifica los datos enviados."))
                .andExpect(jsonPath("$.details").value("El id del evento no puede ser 0."));
    }
    
    @Test
    public void shouldReturnException_InvalidNumeroTarjeta() throws Exception {
        peticionCompra.setNumeroTarjeta("1234123412341234");;
        
        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Intento de compra fallido."))
                .andExpect(jsonPath("$.details").value("Error al realizar la compra: El número de la tarjeta no es válido."));
    }
    
    @Test
    public void shouldReturnException_InvalidMesCaducidad() throws Exception {
        peticionCompra.setMesCaducidad(25);
        
        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Intento de compra fallido."))
                .andExpect(jsonPath("$.details").value("Error al realizar la compra: El mes de caducidad no es correcto."));
    }
    
    @Test
    public void shouldReturnException_InvalidYearCaducidad() throws Exception {
        peticionCompra.setYearCaducidad(1999);
        
        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Intento de compra fallido."))
                .andExpect(jsonPath("$.details").value("Error al realizar la compra: El año de caducidad no es correcto."));
    }
    
    @Test
    public void shouldReturnException_InvalidCvv() throws Exception {
        peticionCompra.setCvv(111111);
        
        String peticionCompraJson = objectMapper.writeValueAsString(peticionCompra);

        mockMvc.perform(post("/nuevaCompra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(peticionCompraJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Intento de compra fallido."))
                .andExpect(jsonPath("$.details").value("Error al realizar la compra: El formato del CVV no es válido."));
    }
    
}
