package com.capgeticket.serviciocompra.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.feignclients.BancoFeignClient;
import com.capgeticket.feignclients.EventosFeignClient;
import com.capgeticket.serviciocompra.error.ReciboCompraIncorrectaException;
import com.capgeticket.serviciocompra.model.Evento;

import jakarta.transaction.Transactional;

import com.capgeticket.serviciocompra.repository.CompraRepository;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
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
	private EventosFeignClient eventosFeign;

	@Autowired
	private BancoFeignClient bancoFeign;

	
	/**
	 * Método que se encarga de obtener un evento a partir
	 * 
	 * @param idEvento El identificador único del evento que se desea obtener.
	 * @return Evento Un objeto  que representa el evento solicitado.
	 *         
	 */
	private Evento obtenerEvento(Long idEvento) {
		Evento evento = eventosFeign.obtenerEventoPorId(idEvento);
		return evento;
	}

	/**
	 * Método para para obtener el nombre del titular.
	 * 
	 * @param email Dirección de correo electrónico de la cual se extrae el nombre
	 *              del titular.
	 * @return Nombre del titular.
	 */
	private static String obtenerNombreTitular(String email) {

		String[] nombreTitular = email.split("@");

		return nombreTitular[0];

	}

	
	/**
	 * Método para realizar una compra utilizando los datos proporcionados  
	 * 
	 * @param datosCompraResponse Objeto que contiene los datos necesarios para realizar la compra.
	 * @return ReciboCompraResponse Un objeto que representa la respuesta de la compra
	 * @throws ReciboCompraIncorrectaException Si hay un error en la compra, devuelve un 
	 *                                          código de error 400 en la respuesta.
	 */
	public ReciboCompraResponse realizarCompra(DatosCompraResponse datosCompraResponse) {

		ReciboCompraResponse reciboCompra = bancoFeign.comprarTicket(datosCompraResponse);

		if (String.valueOf(reciboCompra.getStatus()).equals("400")) {
		    throw new ReciboCompraIncorrectaException("Error al realizar la compra");
		}
		return reciboCompra;
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
}
