package com.capgeticket.job;

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
public class EstadisticasItemProcessor implements ItemProcessor<Compra, EstadisticasCompra> {


	/**
	 * Este método procesa una sola compra y devuelve un objeto EstadisticasCompra con el evento y precio.
	 */
	@Override
	public EstadisticasCompra process(Compra compra) {
		if (compra == null) {
			log.info("--La compra es nula y no será procesada.");
			return null;
		}

		// Creación de EstadisticasCompra basada en una única compra
		EstadisticasCompra estadistica = EstadisticasCompra.builder()
				.idEvento(compra.getIdEvento())
				.precioMedio(compra.getPrecio())
				.diaActual(compra.getFecha().toLocalDate())
				.build();

		log.info("Estadística calculada: " + estadistica);
		return estadistica;
	}
}
