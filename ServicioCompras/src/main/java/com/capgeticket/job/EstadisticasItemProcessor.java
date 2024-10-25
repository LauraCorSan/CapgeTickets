package com.capgeticket.job;

import java.util.UUID;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class EstadisticasItemProcessor implements ItemProcessor<List<Compra>, EstadisticasCompra> {

    /**
     * Este método calcula la media de los precios de una lista de compras
     * y devuelve un objeto EstadisticasCompra.
     */
    @Override
    public EstadisticasCompra process(List<Compra> compras) {
        if (compras == null || compras.isEmpty()) {
            log.warn("No hay compras para procesar.");
            return null; // Manejo de caso vacío
        }

        // Calcular la media de los precios
        double precioMedio = compras.stream()
                .mapToDouble(Compra::getPrecio)
                .average()
                .orElse(0.0); // Si no hay compras, el precio medio es 0

        // Obtener el idEvento del primer elemento de la lista
        Long idEvento = compras.get(0).getIdEvento();

        // Crear el objeto EstadisticasCompra
        EstadisticasCompra estadisticasCompra = EstadisticasCompra.builder()
                .idEvento(idEvento)
                .precioMedio(precioMedio)
                .diaActual(LocalDateTime.now()) // Timestamp actual
                .build();

        log.info("Estadísticas calculadas: " + estadisticasCompra);
        return estadisticasCompra;
    }
}