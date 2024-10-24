package com.capgeticket.serviciocompra.adapter;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.Evento;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.CompraResponse;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;



@Component
public class CompraAdapter {
	public CompraResponse toDTO(Compra compra) {
	    return CompraResponse.builder()
	            .id(compra.getIdCompra())                
	            .idEvento(compra.getIdEvento())     
	            .precio(compra.getPrecio())               
	            .fecha(compra.getFecha())                 
	            .email(compra.getEmail())                 
	            .build();
	}

	public Compra toEntity(CompraResponse compraDto) {
	    return Compra.builder()
	            .idCompra(compraDto.getId())        
	            .idEvento(compraDto.getIdEvento())                           
	            .precio(compraDto.getPrecio())         
	            .fecha(compraDto.getFecha())              
	            .email(compraDto.getEmail())          
	            .build();                                  
	}
	
	
	public DatosCompraResponse toDatosCompraDto(String nombreTitular, String nombreEvento, Double cantidad,PeticionCompraResponse peticion ) {
		return DatosCompraResponse.builder()
				.nombreTitular(nombreTitular)
				.numeroTarjeta(peticion.getNumTrajeta())
				.mesCaducidad(peticion.getMesCaducidad())
				.yearCaducidad(peticion.getYearCaducidad())
				.cvv(peticion.getCvv())
				.emisor(peticion.getEmisor())
				.concepto(nombreEvento)
				.cantidad(cantidad)
				.build();
	}
	
	public CompraConfirmadaResponse toCompraConfirmadaDto(String email, ReciboCompraResponse recibo) {
		return CompraConfirmadaResponse.builder()
				.nombreEvento(recibo.getInfo().getConcepto())
				.fecha(recibo.getTimestamp())
				.precio(recibo.getInfo().getCantidad())
				.email(email)
				.build();
	}
	
	public CompraResponse toCompraResponse(Long idEvento, Double precio, LocalDateTime fecha , String email) {
		return CompraResponse.builder()
				.idEvento(idEvento)
				.precio(precio)
				.fecha(fecha)
				.email(email)
				.build();
	}

	
}
