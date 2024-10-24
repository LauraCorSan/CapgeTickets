package com.capgeticket.serviciocompra.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.feignclients.EventosFeignClient;
import com.capgeticket.serviciocompra.model.Evento;

import jakarta.transaction.Transactional;

import com.capgeticket.serviciocompra.repository.CompraRepository;


/**
* Clase: CompraServiceImpl Descripción: clase de servicio que utiliza el
* repositorio para la gestion de datos de  Compras
* Versión: 2.0
*  Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
*/
@Transactional
@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
    private CompraRepository compraRepository;
	
	@Autowired 
	private EventosFeignClient eventosFeign;
	
	public Evento evento;
	
	public Evento obtenerEvento(Long idEvento) {
		this.evento = eventosFeign.obtenerEventoPorId(idEvento);		
		return evento;
		
	}
	
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

