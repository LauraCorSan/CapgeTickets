package com.capgeticket.resteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgeticket.resteventos.model.Evento;

// Extiende de JpaRepository por lo que Spring ya nos da la implementación de los metodos basicos de CRUD
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
