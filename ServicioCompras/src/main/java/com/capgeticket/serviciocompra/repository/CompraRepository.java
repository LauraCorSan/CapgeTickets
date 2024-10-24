package com.capgeticket.serviciocompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgeticket.serviciocompra.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
