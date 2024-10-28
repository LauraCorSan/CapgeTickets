package com.capgeticket.serviciocompra.job;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import com.capgeticket.serviciocompra.repository.EstadisticasRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class EstadisticasItemWriter implements ItemWriter<EstadisticasCompra> {

	@Autowired
	private EstadisticasRepository estadisticasRepository;

	/**
	 * Método write que guarda cada EstadisticasCompra en la base de datos.
	 */
	@Override
	    public void write(Chunk<? extends EstadisticasCompra> list) throws Exception {
        log.info("-- Datos guardados en la BBDD: " + estadisticasRepository.saveAll(list));
	    }

}