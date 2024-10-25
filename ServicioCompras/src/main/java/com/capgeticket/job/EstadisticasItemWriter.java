package com.capgeticket.job;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import com.capgeticket.serviciocompra.repository.EstadisticasRepository;

@Component
public class EstadisticasItemWriter implements ItemWriter<EstadisticasCompra> {

    @Autowired
    private EstadisticasRepository estadisticasRepository;

    /**
     * Método write que guarda la lista de EstadisticasCompra en la base de datos.
     */
    @Override
    public void write(Chunk<? extends EstadisticasCompra> chunk) throws Exception {
        List<? extends EstadisticasCompra> list = chunk.getItems(); // Obtener los ítems del chunk
        if (list != null && !list.isEmpty()) {
            estadisticasRepository.saveAll(list); // Utiliza el EstadisticasRepository para guardar
        } else {
            // Manejo de caso vacío
            System.out.println("No hay estadísticas para guardar.");
        }
    }
}