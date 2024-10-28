package com.capgeticket.serviciocompra.job;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class EstadisticasItemProcessor implements ItemProcessor<Compra, EstadisticasCompra> {

    @Override
    public EstadisticasCompra process(Compra compra) {
        if (compra == null) {
            log.info("-- No hay compras para procesar.");
            return null;
        }


        EstadisticasCompra estadistica = EstadisticasCompra.builder()
                .idEvento(compra.getIdEvento())
                .precioMedio(compra.getPrecio()) 
                .diaActual(LocalDate.now())
                .build();

     
        log.info("Estadísticas calculadas: " + estadistica);
        return estadistica;
    }
}

