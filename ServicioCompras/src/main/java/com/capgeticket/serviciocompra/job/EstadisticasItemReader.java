package com.capgeticket.serviciocompra.job;




import java.util.List;

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
public class EstadisticasItemReader implements ItemReader<List<Compra>> {

    @Autowired
    private CompraRepository compraRepository;

    private List<Compra> compras;

    private boolean hasRead = false;  

    @BeforeStep
    public void before(StepExecution stepExecution) {
        if (!hasRead) {
            compras = compraRepository.findAll();
            log.info("-- Datos cargados de la BBDD: " + compras);
        }
    }

    @Override
    public List<Compra> read() {
        if (!hasRead) {
            hasRead = true;  
            return compras;
        } else {
            return null;  
        }
    }
}

