package com.capgeticket.serviciocompra.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.feignclients.EventosFeignClient;
import com.capgeticket.serviciocompra.adapter.CompraAdapter;
import com.capgeticket.serviciocompra.error.PeticionCompraIncorrectaException;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.Evento;

import jakarta.transaction.Transactional;

import com.capgeticket.serviciocompra.repository.CompraRepository;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.CompraResponse;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;

/**
 * Clase: CompraServiceImpl Descripción: clase de servicio que utiliza el
 * repositorio para la gestion de datos de Compras Versión: 2.0 Autores: Laura
 * Gregorio, Laura Cordero, Elena, Guillermo, Veronica
 */
@Transactional
@Service
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private CompraAdapter compraAdapter;

	@Autowired
	private EventosFeignClient eventosFeign;

	public CompraConfirmadaResponse nuevaCompra(PeticionCompraResponse peticion) {
		validarPeticion(peticion);
		// obetenemos el titular a partir del email
		String nombreTitular = obtenerNombreTitular(peticion.getEmail());
		// tenemos el evento
		Evento eventoComprado = obtenerEvento(peticion.getIdEvento());
		Double cantidad = obtenerPrecio(eventoComprado.getPrecioMin(), eventoComprado.getPrecioMax());
		String nombreEvento = eventoComprado.getNombre();
		
		DatosCompraResponse datos = compraAdapter.toDatosCompraDto(nombreTitular, nombreEvento, cantidad, peticion);
		
		ReciboCompraResponse recibo = realizarCompra(datos);
		
		CompraConfirmadaResponse confirmada = compraAdapter.toCompraConfirmadaDto(peticion.getEmail(), recibo);
		
		CompraResponse compraRealizada = compraAdapter.toCompraResponse(eventoComprado.getId(), cantidad, recibo.getTimestamp(), confirmada.getEmail());
		
		Compra compraAlmacenada = compraAdapter.toEntity(compraRealizada);
		
		compraRepository.save(compraAlmacenada);
		
		return confirmada;
	}

	private ReciboCompraResponse realizarCompra(DatosCompraResponse datos) {
		// TODO Auto-generated method stub
		return null;
	}

	private Evento obtenerEvento(Long idEvento) {
		Evento evento = eventosFeign.obtenerEventoPorId(idEvento);
		return evento;

	}

	/**
	 * Método para para obtener el nombre del titular.
	 *
	 * @author elena
	 * @param email Dirección de correo electrónico de la cual se extrae el nombre
	 *              del titular.
	 * @return Nombre del titular.
	 */
	private static String obtenerNombreTitular(String email) {

		String[] nombreTitular = email.split("@");

		return nombreTitular[0];

	}

	/**
	 * Calcula el precio del evento realizando un random entre ambos
	 * 
	 * @param Recibe dos double que corresponden al precio min y max de evento
	 * @return un double que es el precio del evento
	 */
	private static Double obtenerPrecio(Double precioMin, Double precioMax) {
		Random random = new Random();
		return precioMin + (precioMax - precioMin) * random.nextDouble();
	}

	public void validarPeticion(PeticionCompraResponse peticion) {
	}
}
