package com.capgeticket.serviciocompra.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.serviciocompra.adapter.CompraAdapter;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.repository.CompraRepository;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;

/**
* Clase: CompraServiceImpl Descripción: clase de servicio que utiliza el
* repositorio para la gestion de datos de  Compras
* Versión: 2.0
*  Autores: Laura Gregorio, Laura Cordero, Elena, Guillermo, Veronica
*/
@Service
public class CompraServiceImpl implements CompraService {
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	CompraAdapter compraAdapter;

	@Override
	public CompraConfirmadaResponse nuevaCompra(PeticionCompraResponse peticionCompraResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Llama al repositorio de compra para realizar una compra en eventos
	 *
	 * @author Guillermo
	 * @param Recibe un objeto de tipo Compra
	 * @return Resultado de la llamada al metodo save en repositorio 
	 */
	
	 
}
