package com.capgeticket.serviciocompra.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.serviciocompra.model.Compra;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Clase: CompraResponse
 * Descripción: clase dto con los datos más relevantes
 * Fecha: 23/10/24
 * Versión: 1.0
 * Autores: Guillermo Garcia
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;                   
    private Long idEvento;              
    private double precio;          
    private String email;  
    
    private LocalDateTime fecha;        
}