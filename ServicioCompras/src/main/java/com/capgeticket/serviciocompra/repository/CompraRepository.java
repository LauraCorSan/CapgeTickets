package com.capgeticket.serviciocompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgeticket.serviciocompra.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}
