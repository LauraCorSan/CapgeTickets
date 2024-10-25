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

//@Slf4j
//public class EstadisticasItemProcessor implements ItemProcessor<Compra, EstadisticasCompra> {
//
//	/**
//	 * Este método calcula la media de los precios de una lista de compras y devuelve 
//	 * una lista de objetos EstadisticasCompra, cada uno con el promedio de precios por evento.
//	 */
//	@Override
//	public EstadisticasCompra process(Compra compras) {
//		if (compras == null || compras.isEmpty()) {
//			log.info("--No hay compras para procesar.");
//			return Collections.emptyList();
//		}
//
//		Map<Long, Double> mediaPreciosPorEvento = compras.stream()
//				.filter(compra -> compra.getFecha().toLocalDate().isEqual(LocalDate.now()))
//				.collect(Collectors.groupingBy(Compra::getIdEvento, Collectors.averagingDouble(Compra::getPrecio)));
//
//		List<EstadisticasCompra> estadisticasCompra = mediaPreciosPorEvento.entrySet().stream()
//				.map(entry -> EstadisticasCompra.builder()
//					.idEvento(entry.getKey())
//					.precioMedio(entry.getValue())
//					.diaActual(LocalDate.now())
//					.build())
//				.collect(Collectors.toList());
//
//		log.info("Estadísticas calculadas: " + estadisticasCompra);
//		return estadisticasCompra;
//	}
//}
