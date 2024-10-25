package com.capgeticket.serviciocompra.listener;

import org.springframework.batch.core.ItemProcessListener;

import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EstadisticasItemProcessListener implements ItemProcessListener<EstadisticasCompra, Compra> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstadisticasItemProcessListener.class);

    @Override
    public void beforeProcess(EstadisticasCompra estadisticaCompra) {
        LOGGER.info("##### beforeProcess");
    }

    @Override
    public void afterProcess(EstadisticasCompra estadisticaCompra, Compra compra) {
        LOGGER.info("##### afterProcess: " + estadisticaCompra + " ---> " + compra);
    }

    @Override
    public void onProcessError(EstadisticasCompra estadisticaCompra, Exception e) {
        LOGGER.info("onProcessError");
    }
}