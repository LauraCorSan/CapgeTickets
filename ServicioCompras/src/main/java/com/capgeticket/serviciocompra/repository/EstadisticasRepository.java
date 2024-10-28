package com.capgeticket.serviciocompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

@Repository
public interface EstadisticasRepository extends JpaRepository<EstadisticasCompra, Long> {

}
