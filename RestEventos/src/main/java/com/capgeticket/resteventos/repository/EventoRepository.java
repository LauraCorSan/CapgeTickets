package com.capgeticket.resteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgeticket.resteventos.model.Evento;

public interface EventoRepository  extends JpaRepository<Evento, Long> {

}
