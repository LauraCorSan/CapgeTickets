package com.capgeticket.serviciocompra.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.serviciocompra.repository.CompraRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
* Clase: CompraServiceImpl Descripción: clase de servicio que utiliza el
* repositorio para la gestion de datos de  Compras
* Versión: 2.0
*  Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
*/

public class CompraServiceImpl implements CompraService {
	
	@Autowired
    private CompraRepository compraRepository;

	/**
	 * Método para para obtener el nombre del titular.
	 *
	 * @author elena
	 * @param email Dirección de correo electrónico de la cual se extrae el nombre del titular.
	 * @return Nombre del titular.
	 */
	public String obtenerNombreTitular(String email) {
	    
	    String[] nombreTitular = email.split("@");
	    
	    return nombreTitular[0];
	}


}
