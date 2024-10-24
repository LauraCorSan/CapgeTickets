package com.capgeticket.serviciocompra.service;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.feignclients.EventosFeignClient;
import com.capgeticket.resteventos.error.EventoInvalidoException;
import com.capgeticket.serviciocompra.error.PeticionCompraIncorrectaException;
import com.capgeticket.serviciocompra.error.ReciboCompraIncorrectaException;
import com.capgeticket.serviciocompra.model.Evento;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;

import jakarta.transaction.Transactional;

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

	@Autowired
	private EventosFeignClient eventosFeign;

	public Evento evento;

	public Evento obtenerEvento(Long idEvento) {
		this.evento = eventosFeign.obtenerEventoPorId(idEvento);
		return evento;

	}

	/**
	 * validarPeticion() Se encarga de validar los campos de
	 * CompraConfirmadaResponse
	 *
	 * @author vparrag
	 * @param CompraConfirmadaResponse
	 */

	@Autowired
	public CompraConfirmadaResponse compraConfirmadaResponse;

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
