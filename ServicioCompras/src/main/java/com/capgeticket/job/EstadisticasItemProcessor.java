package com.capgeticket.job;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
public class EstadisticasItemProcessor implements ItemProcessor<List<Compra>, List<EstadisticasCompra>> {

    /**
     * Este método calcula la media de los precios de una lista de compras y devuelve 
     * una lista de objetos EstadisticasCompra, cada uno con el promedio de precios por evento.
     */
    @Override
    public List<EstadisticasCompra> process(List<Compra> compras) {
       
    	
    	if (compras == null || compras.isEmpty()) {
            log.info("-- No hay compras para procesar.");
            return Collections.emptyList(); 
        }
    	
    	

        Map<Long, Double> sumaPreciosPorEvento = new HashMap<>();
        Map<Long, Integer> conteoPorEvento = new HashMap<>();

     
        for (Compra stcompra : compras) {
            
            if (stcompra.getFecha() != null && stcompra.getFecha().toLocalDate().isEqual(LocalDate.now())) {
                Long idEvento = stcompra.getIdEvento();
                Double precio = stcompra.getPrecio();

                sumaPreciosPorEvento.put(idEvento, sumaPreciosPorEvento.getOrDefault(idEvento, 0.0) + precio); 
                conteoPorEvento.put(idEvento, conteoPorEvento.getOrDefault(idEvento, 0) + 1);
            }
        }

        List<EstadisticasCompra> estadisticasCompra = new ArrayList<>();

        
        for (Long idEvento : sumaPreciosPorEvento.keySet()) {
            Double sumaPrecios = sumaPreciosPorEvento.get(idEvento);
            Integer conteo = conteoPorEvento.get(idEvento);
            Double precioMedio = sumaPrecios / conteo;

           
            EstadisticasCompra estadistica = EstadisticasCompra.builder()
                .idEvento(idEvento)
                .precioMedio(precioMedio)
                .diaActual(LocalDate.now())
                .build();

            estadisticasCompra.add(estadistica);
        }

        log.info("Estadísticas calculadas: " + estadisticasCompra);
        return estadisticasCompra; 
    }
}