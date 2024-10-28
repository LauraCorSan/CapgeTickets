package com.capgeticket.serviciocompra.adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.CompraResponse;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;

/**
 * Clase: CompraAdapt 
 * Descripción: la clase que parsea disitntos tipos de response a otros que son necesarios
 * Fecha: 24/10/24
 * Versión: 1.0 
 * Autores: Guillermo
 */

@Component
public class CompraAdapter {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	 // Definir el formato

	public CompraResponse toDTO(Compra compra) {
	    return CompraResponse.builder()
	            .id(compra.getIdCompra())                
	            .idEvento(compra.getIdEvento())     
	            .precio(compra.getPrecio())               
	            .fecha(compra.getFecha().toString())              
	            .email(compra.getEmail())                 
	            .build();
	}

	public Compra toEntity(CompraResponse compraDto) {
	    return Compra.builder()
	            .idCompra(compraDto.getId())        
	            .idEvento(compraDto.getIdEvento())                           
	            .precio(compraDto.getPrecio())         
	            .fecha( LocalDateTime.parse(compraDto.getFecha(), FORMATTER).toLocalDate())
	            .email(compraDto.getEmail())          
	            .build();                                  
	}
	
	
	public DatosCompraResponse toDatosCompraDto(String nombreTitular, String nombreEvento, Double cantidad,PeticionCompraResponse peticion ) {
	    double cantidadDosDecimales = Math.floor(cantidad * 100) / 100;
		return DatosCompraResponse.builder()
				.nombreTitular(nombreTitular)
				.numeroTarjeta(peticion.getNumeroTarjeta())
				.mesCaducidad(peticion.getMesCaducidad())
				.yearCaducidad(peticion.getYearCaducidad())
				.cvv(peticion.getCvv())
				.emisor(peticion.getEmisor())
				.concepto(nombreEvento)
				.cantidad(cantidadDosDecimales)
				.build();
	}
	
	public CompraConfirmadaResponse toCompraConfirmadaDto(String email, ReciboCompraResponse recibo) {
		return CompraConfirmadaResponse.builder()
				.mensaje(String.format(
		                "Compra registrada con éxito el día %s para el evento: %s, precio: %.2f, usuario: %s.",
		                recibo.getTimestamp().split(" ")[0],  
		                recibo.getInfo().getConcepto(),
		                recibo.getInfo().getCantidad(),   
		                recibo.getInfo().getNombreTitular() 
		            ))
				.nombreEvento(recibo.getInfo().getConcepto())
				.fecha(recibo.getTimestamp().split(" ")[0])
				.precio(recibo.getInfo().getCantidad())
				.email(email)
				.build();
	}
	
	public CompraResponse toCompraResponse(Long idEvento, double precio, String fecha , String email) {
		return CompraResponse.builder()
				.idEvento(idEvento)
				.precio(precio)
				.fecha(fecha)
				.email(email)
				.build();
	}

	
}