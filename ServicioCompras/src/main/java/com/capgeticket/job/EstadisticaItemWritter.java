package com.capgeticket.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/*
@Component
public class EstadisticasItemWriter implements ItemWriter<EstadisticasCompra> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends EstadisticasCompra> estadisticasCompras) {
        // Guardar cada objeto EstadisticasCompra en la base de datos
        for (EstadisticasCompra estadisticas : estadisticasCompras) {
            jdbcTemplate.update(
                    "INSERT INTO EstadisticasCompra (media_precio, total_compras) VALUES (?, ?)",
                    estadisticas.getMediaPrecio(),
                    estadisticas.getTotalCompras()
            );
        }
    }
}
*/