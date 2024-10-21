package com.capgeticket.resteventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.capgeticket.resteventos.model.Evento;

import org.springframework.stereotype.Repository;

import com.capgeticket.resteventos.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Long>{


}
