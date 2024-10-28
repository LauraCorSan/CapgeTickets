package com.capgeticket.serviciocompra.job;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase: EstadisticasItemProcessor
 * Descripción: clase que calcula el precio medio de las compras de cada evento el día actual
 * Fecha: 28/10/24
 * Versión: 1.0 
 * Autores: Laura Gregorio
 */
@Slf4j
@Component
public class EstadisticasItemProcessor implements ItemProcessor<List<Compra>, EstadisticasCompra> {

    private List<EstadisticasCompra> estadisticasCompra; 
    private Iterator<EstadisticasCompra> iterator;

    @Override
    public EstadisticasCompra process(List<Compra> compras) {
        if (compras == null || compras.isEmpty()) {
            log.info("-- No hay compras para procesar.");
            return null;
        }

        // Recalcula solo si el iterator es nulo o ya terminó
        if (iterator == null || !iterator.hasNext()) {
            // Agrupa las compras por evento y calcula el precio medio solo para la fecha actual
            Map<Long, Double> mediaPreciosPorEvento = compras.stream()
                .filter(compra -> compra.getFecha().isEqual(LocalDate.now()))
                .collect(Collectors.groupingBy(
                    Compra::getIdEvento,
                    Collectors.averagingDouble(Compra::getPrecio)
                ));

            estadisticasCompra = mediaPreciosPorEvento.entrySet().stream()
                .map(entry -> EstadisticasCompra.builder()
                    .idEvento(entry.getKey())
                    .precioMedio(entry.getValue())
                    .diaActual(LocalDate.now())
                    .build())
                .collect(Collectors.toList());
            log.info("Lista de estadisticas para cada evento de hoy",estadisticasCompra);

            iterator = estadisticasCompra.iterator(); 
        }

        if (iterator.hasNext()) {
            EstadisticasCompra estadistica = iterator.next();
            log.info("Estadística calculada para el evento {}: {}", estadistica.getIdEvento(), estadistica);
            return estadistica;
        } else {
            log.info("-- No hay más estadísticas para procesar.");
            return null; 
        }
    }
}



