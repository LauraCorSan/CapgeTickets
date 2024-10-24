package com.capgeticket.serviciocompra.adapter;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.Evento;
import com.capgeticket.serviciocompra.response.CompraResponse;



@Component
public class CompraAdapter {
	public CompraResponse toDTO(Compra compra) {
	    return CompraResponse.builder()
	            .id(compra.getIdCompra())                
	            .idEvento(compra.getEvento().getId())     
	            .precio(compra.getPrecio())               
	            .fecha(compra.getFecha())                 
	            .email(compra.getEmail())                 
	            .build();
	}
	/**
	 * Convierte una lista de objetos Compra en una lista de objetos CompraResponse.
	 * @param compras La lista de objetos Compra que se van a convertir.
	 * @return Una lista de objetos CompraResponse resultantes.
	 */
	public List<CompraResponse> toDTOList(List<Compra> compras) {
	    return compras.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public Compra toEntity(CompraResponse compraDto, Evento evento) {
	    return Compra.builder()
	            .idCompra(compraDto.getId())        
	            .evento(evento)                           
	            .precio(compraDto.getPrecio())         
	            .fecha(compraDto.getFecha())              
	            .email(compraDto.getEmail())          
	            .build();                                  
	}

	
}
