package com.capgeticket.serviciocompra.job;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import com.capgeticket.serviciocompra.repository.EstadisticasRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase: EstadisticasItemWriter Descripción: clase que añade las estadisticas a
 * la base de datos Fecha: 28/10/24 Versión: 1.0 Autores: Laura Gregorio
 */
@Slf4j
@Component
public class EstadisticasItemWriter implements ItemWriter<EstadisticasCompra> {

	@Autowired
	private EstadisticasRepository estadisticasRepository;

	/**
	 * Método write que guarda cada EstadisticasCompra en la base de datos.
	 */

	@Override
	public void write(Chunk<? extends EstadisticasCompra> items) throws Exception {
		// TODO Auto-generated method stub
		estadisticasRepository.saveAll(items);
        log.info("-- Datos guardados en la BBDD: " + estadisticasRepository.saveAll(items));

	}

}
