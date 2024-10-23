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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


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
	 * Llama al servicio de evento para realizar la operacion de guardado
	 * lanza una excepción si no encuentra el evento
	 * @param Recibe un id del objeto a editar y objeto de tipo Evento en formato json
	 * @return Un evento dto
	 */
	
	@Operation(
			summary = "Modificar un evento existente", 
            description = "Llama al servicio de evento para modificar un evento existente dado su ID."
              )
	@ApiResponses(value = {
			@ApiResponse(
						responseCode = "200", 
						description = "Evento modificado correctamente."
						),
			@ApiResponse(
						responseCode = "404", 
						description = "El evento con el ID proporcionado no fue encontrado."
						)
				}
			)
	@PutMapping("/modificar/{id}")
	public EventoResponse modificarEvento(@PathVariable Long id, @RequestBody EventoResponse evento){
		final Optional<Evento> e = eventoService.buscarPorId(id);
		if(e.isEmpty())throw new EventoNotFoundException("El id "+id+" no se ha encontrado");
		evento.setId(id);
		Evento event = eventoService.aniadirEvento(eventoAdapter.toEntity(evento));
		return eventoAdapter.toDTO(event);

	}

	/**
	 * Llama al servicio de evento para realizar la operacion de guardado
	 * 
	 * @param Recibe un objeto de tipo Evento en formato json
	 * @return Un evento dto
	 */
	@Operation(
			summary = "Añadir un nuevo evento", 
            description = "Crea un nuevo evento con la información proporcionada."
              )
	@ApiResponses(value = {
			@ApiResponse(
						responseCode = "201", 
						description = "Evento creado correctamente."
						),
			@ApiResponse(
						responseCode = "400", 
						description = "Solicitud inválida."
						)
					}
			)
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
	@Operation(
			summary = "Listar todos los eventos", 
            description = "Devuelve una lista de todos los eventos disponibles."
              )
	@ApiResponses(value = {
			@ApiResponse(
					responseCode = "200", 
					description = "Lista de eventos devuelta correctamente."
						),
			@ApiResponse(
					responseCode = "404", 
					description = "No se encontraron eventos."
						)
				}
			)
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
	 @Operation(
			 summary = "Detalles de un evento", 
             description = "Devuelve los detalles del evento dado su ID."
               )
  @ApiResponses(value = {
		  @ApiResponse(
				  responseCode = "200", 
				  description = "Detalles del evento devueltos correctamente."
				  	  ),
		  @ApiResponse(
				  responseCode = "404", 
				  description = "El evento con el ID proporcionado no fue encontrado."
				      )
  				}
		  )
	@GetMapping("/{id}")
	public EventoResponse detallesEvento(@PathVariable Long id) {

		if (id < 0) {
	        throw new EventoNotFoundException("El id " + id + " no se ha encontrado"); // Lanza la excepción si el ID es inválido
	    }
	    Evento evento = eventoService.detallesEvento(id);
	    return eventoAdapter.toDTO(evento);
	}
	
	/**
	 * Lista eventos por nombre
	 * 
	 * @author laura gregorio
	 * @param id El ID del evento que se desea buscar.
	 * @return El objeto correspondiente al nombre proporcionado.
	 */
	@GetMapping("/nombre/{nombre}")
	public List<EventoResponse> listarPorNombre(@PathVariable String nombre) {
		List<EventoResponse> eventos = eventoAdapter.toDTOList(eventoService.buscarPorNombre(nombre));
		if (eventos.isEmpty()) {
	        throw new EventoNotFoundException("No existe ningún evento con el nombre " + nombre); 

		}
		return eventos;
	}

	/**
	 * Elimina un evento específico basado en su ID.
	 * 
	 * @param id El ID del evento que se desea eliminar.
	 * @return Una respuesta HTTP que indica el resultado de la operación: - Código
	 *         200: Si el evento fue eliminado correctamente. - Código 404: Si no se
	 *         encontró el evento con el ID proporcionado.
	 */
	 @Operation(
				summary = "Eliminar un evento", description = "Elimina un evento específico dado su ID."
               )
	 @ApiResponses(value = {
			 @ApiResponse(
					 responseCode = "200", 
					 description = "Evento eliminado correctamente."
					     ),
			 @ApiResponse(
					 responseCode = "404", 
					 description = "Evento no encontrado."
					     ),
			 @ApiResponse(
					 responseCode = "500", 
					 description = "Error interno del servidor."
					     )
	 				}
			 )
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
