package com.capgeticket.resteventos.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.adapter.EventoAdapter;

import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.response.EventoResponse;

import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.resteventos.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	EventoRepository eventoRepository;

	@Autowired
	private EventoAdapter eventoAdapter;

	@Autowired
	private EventoService eventoService;

	/**
	 * Solicitud GET para listar todos los eventos.
	 *
	 * @return Una lista de objetos EventoResponse que representan todos los
	 *         eventos.
	 */
	@GetMapping("/listarEventos")
	public ResponseEntity<List<EventoResponse>> getEventoAll() {
		List<EventoResponse> eventos = eventoAdapter.of(eventoRepository.findAll());

		if (eventos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(eventos);
	}

	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}

	/**
	 * Elimina un evento específico basado en su ID.
	 *
	 * @param id El ID del evento que se desea eliminar.
	 * @return Una respuesta HTTP que indica el resultado de la operación: - Código
	 *         200: Si el evento fue eliminado correctamente. - Código 404: Si no se
	 *         encontró el evento con el ID proporcionado.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEvento(@PathVariable Long id) {
		try {
			Evento eventoEliminado = eventoService.eliminarEvento(id);

			if (eventoEliminado == null) {
				return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("Evento no encontrado.");
			}

			return ResponseEntity.ok("Evento eliminado correctamente.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Error al eliminar el evento.");
		}
	}

}
