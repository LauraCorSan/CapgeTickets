package com.capgeticket.serviciocompra.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgeticket.serviciocompra.model.Compra;

/**
 * Interfaz: CompraRepository Descripción: interfaz que extiende jpaRespository
 * Fecha: 23/10/24 Versión: 1.0 Autores: Laura Gregorio
 */

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	

}
