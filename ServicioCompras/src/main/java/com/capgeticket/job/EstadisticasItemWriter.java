package com.capgeticket.job;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import com.capgeticket.serviciocompra.repository.EstadisticasRepository;


public class EstadisticasItemWriter  {

	@Autowired
	private EstadisticasRepository estadisticasRepository;

	
	}

	/**
	 * Método write que guarda la lista de EstadisticasCompra en la base de datos.
	 */
	
	

	/*@Override
	public void write(Chunk<? extends EstadisticasCompra> chunk) throws Exception {
		

		    int chunkSize = 10; // Define el tamaño del chunk (puedes ajustar este valor)
		    for (int i = 0; i < list.size(); i += chunkSize) {
		        // Determina el final del chunk
		        int end = Math.min(i + chunkSize, list.size());
		        List<EstadisticasCompra> chunk = list.subList(i, end); // Extrae el chunk

		        try {
		            // Guarda cada estadística en el chunk
		            estadisticasRepository.saveAll(chunk); // Usa saveAll para guardar todo el chunk de una vez
		            log.info("-- Se han guardado " + chunk.size() + " estadísticas en la base de datos.");
		        } catch (Exception e) {
		            log.error("Error al guardar estadísticas en la base de datos: " + e.getMessage(), e);
		            throw e; // Lanzar la excepción para que Spring Batch la maneje
		        }
		    }
		
	}*/