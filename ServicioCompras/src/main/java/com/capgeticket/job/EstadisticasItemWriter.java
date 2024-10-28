package com.capgeticket.job;

import java.util.List;

//import org.springframework.batch.item.Chunk;
//import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import com.capgeticket.serviciocompra.repository.EstadisticasRepository;


//public class EstadisticasItemWriter implements ItemWriter<EstadisticasCompra> {
//
//	@Autowired
//	private EstadisticasRepository estadisticasRepository;
//
//	/**
//	 * Método write que guarda la lista de EstadisticasCompra en la base de datos.
//	 */
//	@Override
//	public void write(List<? extends EstadisticasCompra> list) throws Exception {
//		estadisticasRepository.saveAll(list);
//
//	}
//
//
//
//
//}