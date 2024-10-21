package com.capgeticket.resteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgeticket.resteventos.model.Evento;

// Extiende de JpaRepository por lo que Spring ya nos da la implementación de los metodos basicos de CRUD
@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
