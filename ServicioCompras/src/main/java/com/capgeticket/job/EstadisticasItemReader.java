package com.capgeticket.job;


import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.repository.CompraRepository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EstadisticasItemReader implements ItemReader<Compra> {

    @Autowired
    private CompraRepository compraRepository;

    private Iterator<Compra> comprasIterator;

    /**
     * Método before que inicializa el iterador de datos de la tabla Compra.
     */
    @BeforeStep
    public void before(StepExecution stepExecution) {
        comprasIterator = compraRepository.findAll().iterator();
        log.info("-- Datos cargados de la BBDD: " + compraRepository.findAll());
    }

    /**
     * Método read que entrega cada ítem de la lista al Processor.
     */
    @Override
    public Compra read() {
        if (comprasIterator != null && comprasIterator.hasNext()) {
            Compra compra = comprasIterator.next();
            log.info("-- Elemento leído: " + compra);
            return compra;
        } else {
            log.info("---- read(): No hay más datos");
            return null; // Indica fin de datos para el lector
        }
    }
}