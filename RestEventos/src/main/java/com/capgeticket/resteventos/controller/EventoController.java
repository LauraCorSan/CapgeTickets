package com.capgeticket.resteventos.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.apache.hc.core5.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgeticket.resteventos.service.EventoService;
import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.error.EventoNotFoundException;

import com.capgeticket.resteventos.response.EventoResponse;

import com.capgeticket.resteventos.model.Evento;

/**
 * Clase: EventoController Descripción: clase de control (recepcion y
 * procesamiento) de endpoints Fecha: 18/10/24 Versión: 2.0 Autores: Laura
 * Gregorio, Laura Cordero, Elena, Guillermo, Veronica
 */

@RestController
@RequestMapping("/evento")
public class EventoController {
	@Autowired
	private EventoService eventoService;

	@Autowired
	private EventoAdapter eventoAdapter;

	/**
	 * Llama al servicio de evento para realizar la operacion de guardado lanza una
	 * excepción si no encuentra el evento
	 * 
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento adaptado
	 */
	@PutMapping("/modificar/{id}")
	public EventoResponse modificarEvento(@PathVariable Long id, @RequestBody EventoResponse evento) {
		final Optional<Evento> e = eventoService.buscarPorId(id);
		if (e.isEmpty())
			throw new EventoNotFoundException("El id " + id + " no se ha encontrado");

		evento.setId(id);
		Evento event = eventoService.aniadirEvento(eventoAdapter.toEntity(evento));
		return eventoAdapter.toDTO(event);

	}

	/**
	 * Llama al servicio de evento para realizar la operacion de guardado
	 * 
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento fto
	 */

	@PostMapping("/aniadir")
	public EventoResponse aniadirEvento(@RequestBody Evento evento) {
		Evento e = eventoService.aniadirEvento(evento);
		return eventoAdapter.toDTO(e);
	}

	/**
	 * Solicitud GET para listar todos los eventos.
	 *
	 * @return Una lista de objetos EventoResponse que representan todos los
	 *         eventos.
	 */
	@GetMapping("/listarEventos")
	public ResponseEntity<List<EventoResponse>> getEventoAll() {
		List<EventoResponse> eventos = eventoAdapter.toDTOList(eventoService.buscarTodos());

		if (eventos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(eventos);
	}

	/**
	 * Busca los detalles de un evento por su ID.
	 * 
	 * @author vparragr
	 * @param id El ID del evento que se desea buscar.
	 * @return El objeto correspondiente al ID proporcionado.
	 */
	@GetMapping("/{id}")
	public EventoResponse detallesEvento(@PathVariable Long id) {

		if (id < 0) {
	        throw new EventoNotFoundException("El id " + id + " no se ha encontrado"); // Lanza la excepción si el ID es inválido
	    }
	    Evento evento = eventoService.detallesEvento(id);
	    return eventoAdapter.toDTO(evento);
	}

	/**
	 * Elimina un evento específico basado en su ID.
	 * 
	 * @param id El ID del evento que se desea eliminar.
	 * @return Una respuesta HTTP que indica el resultado de la operación: - Código
	 *         200: Si el evento fue eliminado correctamente. - Código 404: Si no se
	 *         encontró el evento con el ID proporcionado.
	 */
	@DeleteMapping("/eliminar/{id}")
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
