package com.capgeticket.job;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.capgeticket.serviciocompra.model.Compra;

import java.util.List;
/*
@Component
public class EstadisticasItemProcessor implements ItemProcessor<List<Compra>, EstadisticasCompra> {

    @Override
    public EstadisticasCompra process(List<Compra> compras) {
        // Calcular la media de los precios de la lista de compras
        double mediaPrecios = compras.stream()
                .mapToDouble(Compra::getPrecio)
                .average()
                .orElse(0.0);

        // Crear y retornar el objeto EstadisticasCompra con la media calculada
        EstadisticasCompra estadisticasCompra = new EstadisticasCompra();
        estadisticasCompra.setMediaPrecio(mediaPrecios);
        estadisticasCompra.setTotalCompras(compras.size());
        
        return estadisticasCompra;
    }
}
*/