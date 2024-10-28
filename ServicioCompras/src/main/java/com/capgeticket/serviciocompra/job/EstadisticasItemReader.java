package com.capgeticket.serviciocompra.job;

import java.util.Iterator;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.repository.CompraRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase: EstadisticasItemReader
 * Descripción: clase que recupera los datos de la base 
 * Fecha: 28/10/24
 * Versión: 1.0 
 * Autores: Laura Gregorio
 */
@Slf4j
@Component
public class EstadisticasItemReader implements ItemReader<Compra> {

    @Autowired
    private CompraRepository compraRepository;

    private Iterator<Compra> comprasIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        comprasIterator = compraRepository.findAll().iterator();
        log.info("-- Datos cargados de la BBDD: " + compraRepository.findAll());
    }

    @Override
    public Compra read() {
        if (comprasIterator != null && comprasIterator.hasNext()) {
            Compra compra = comprasIterator.next();
            log.info("-- Elemento leído: " + compra);
            return compra;
        } else {
            log.info("---- read(): No hay más datos");
            return null; 
        }
    }
}
