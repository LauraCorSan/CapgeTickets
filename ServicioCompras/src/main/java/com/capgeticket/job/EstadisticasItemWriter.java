package com.capgeticket.job;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.EstadisticasCompra;

/*
@Component
public class EstadisticasItemWriter implements ItemWriter<EstadisticasCompra> {

    @Autowired
    private EstadisticasCompraRepository estadisticasCompraRepository;

    /**
     * Método write que guarda la lista de EstadisticasCompra en la base de datos.
     
    @Override
    public void write(List<? extends EstadisticasCompra> list) throws Exception {
        if (list != null && !list.isEmpty()) {
            estadisticasCompraRepository.saveAll(list);
        } else {
            // Manejo de caso vacío
            System.out.println("No hay estadísticas para guardar.");
        }
    }
}
*/