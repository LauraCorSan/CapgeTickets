package com.capgeticket.serviciocompra.service;

import java.util.Random;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.feignclients.BancoFeignClient;
import com.capgeticket.feignclients.EventosFeignClient;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.serviciocompra.adapter.CompraAdapter;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.error.PeticionCompraIncorrectaException;
import com.capgeticket.serviciocompra.error.ReciboCompraIncorrectaException;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;

import jakarta.transaction.Transactional;

import com.capgeticket.serviciocompra.repository.CompraRepository;

import com.capgeticket.serviciocompra.response.CompraResponse;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase: CompraServiceImpl Descripción: clase de servicio que utiliza el
 * repositorio para la gestion de datos de Compras Versión: 2.0 Autores: Laura
 * Gregorio, Laura Cordero, Elena, Guillermo, Veronica
 */
@Transactional
@Service
public class CompraServiceImpl implements CompraService {
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Logger log = LoggerFactory.getLogger(CompraServiceImpl.class);

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private CompraAdapter compraAdapter;

	@Autowired
	private EventosFeignClient eventosFeign;
	
	@Autowired
	private BancoFeignClient bancoFeign;

	public CompraConfirmadaResponse nuevaCompra(PeticionCompraResponse peticion) {
		log.info("--nueva comptra en service");

		validarPeticion(peticion);
		// obetenemos el titular a partir del email
		String nombreTitular = obtenerNombreTitular(peticion.getEmail());
		// tenemos el evento
		log.info("--antes de obtener");

		EventoResponse eventoComprado = obtenerEvento(peticion.getIdEvento());
		log.info("--despues de obtener");

		double cantidad = obtenerPrecio(eventoComprado.getPrecioMin(), eventoComprado.getPrecioMax());
		String nombreEvento = eventoComprado.getNombre();
		
		DatosCompraResponse datos = compraAdapter.toDatosCompraDto(nombreTitular, nombreEvento, cantidad, peticion);
		log.info("--datos:" + datos);

		
		ReciboCompraResponse recibo = realizarCompra(datos);
		
		CompraConfirmadaResponse confirmada = compraAdapter.toCompraConfirmadaDto(peticion.getEmail(), recibo);
		
		CompraResponse compraRealizada = compraAdapter.toCompraResponse(eventoComprado.getId(), cantidad, recibo.getTimestamp(), confirmada.getEmail());
		
		Compra compraAlmacenada = compraAdapter.toEntity(compraRealizada);
		
		//compraRepository.save(compraAlmacenada);
		
		return confirmada;
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
	    log.info("--realizo llamada a banco");
	    ReciboCompraResponse reciboCompra = bancoFeign.comprarTicket(datosCompraResponse);

	    if (reciboCompra == null) {
	        throw new ReciboCompraIncorrectaException("La respuesta del banco es nula");
	    }

	    log.info("--recibo banco: " + reciboCompra);

	    switch (reciboCompra.getStatus()) {
	        case "400":
	            log.info("--Error 400 al realizar la compra: " + reciboCompra.getMessage());
	            throw new ReciboCompraIncorrectaException("Error al realizar la compra: " + reciboCompra.getMessage());
	        case "500":
	            log.info("--Error 500 al realizar la compra: " + reciboCompra.getMessage());
	            throw new ReciboCompraIncorrectaException("Error al realizar la compra: " + reciboCompra.getMessage());
	        default:
	            log.info("--Compra realizada con éxito: " + reciboCompra.getMessage());
	    }

	    return reciboCompra;
	}

	
	
	/**
	 * Método que se encarga de obtener un evento a partir
	 * 
	 * @param idEvento El identificador único del evento que se desea obtener.
	 * @return Evento Un objeto  que representa el evento solicitado.
	 *         
	 */
	private EventoResponse obtenerEvento(Long idEvento) {
		log.info("--antes de feign");

		EventoResponse evento = eventosFeign.obtenerEventoPorId(idEvento);
		log.info("--realizo llamada a eventos"+ evento);

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
	 * Calcula el precio del evento realizando un random entre ambos
	 * 
	 * @param Recibe dos double que corresponden al precio min y max de evento
	 * @return un double que es el precio del evento
	 */
	private static Double obtenerPrecio(Double precioMin, Double precioMax) {
		Random random = new Random();
		return precioMin + (precioMax - precioMin) * random.nextDouble();

	}


	/**
	 * validarPeticion() Se encarga de validar los campos de
	 * CompraConfirmadaResponse
	 *
	 * @author vparrag
	 * @param CompraConfirmadaResponse
	 */

	public void validarPeticion(PeticionCompraResponse peticionCompra) {

		if (peticionCompra.getIdEvento() == null || peticionCompra.getIdEvento() <= 0) {
			throw new PeticionCompraIncorrectaException("El id del evento no puede estar vacío, ser 0 o ser negativo.");
		}

		if (peticionCompra.getEmail() == null || peticionCompra.getEmail().trim().isEmpty()
				|| !EMAIL_PATTERN.matcher(peticionCompra.getEmail()).matches()) {
			throw new PeticionCompraIncorrectaException("El email no puede ser nulo o tener un formato incorrecto.");
		}

	}
	
	 
}
