package com.capgeticket.serviciocompra.listener;

import org.springframework.batch.core.ItemWriteListener;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class EstadisticasItemWriterListener implements ItemWriteListener<Compra> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstadisticasItemWriterListener.class);

    public void beforeWrite(List<? extends Compra> list) {
        LOGGER.info("##### beforeWrite");
    }


    public void afterWrite(List<? extends Compra> list) {
        for (Compra compra : list) {
            LOGGER.info("##### afterWrite :" + compra);
        }
    }

    public void onWriteError(Exception e, List<? extends Compra> list) {
        LOGGER.info("onWriteError");
    }
}
