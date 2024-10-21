package com.capgeticket.resteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capgeticket.resteventos.model.Evento;

<<<<<<< HEAD
/**
 * Interfaz: EventoRepository Descripción: Interfaz que extiende JpaRepository
 * por lo que Spring ya contiene implementación de los metodos mas usuales de
 * ApiRest 
 * Fecha: 18/10/24 
 * Versión: 1.0 
 * Autores: Laura Cordero
 */
=======
import org.springframework.stereotype.Repository;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {


}
