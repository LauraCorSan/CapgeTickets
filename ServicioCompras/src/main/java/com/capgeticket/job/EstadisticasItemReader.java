package com.capgeticket.job;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/*
@Component
public class EstadisticasItemReader {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private JdbcCursorItemReader<Compra> itemReader;

    @PostConstruct
    public void before() {
        // Configura el ItemReader para leer los datos de la tabla Compra
        itemReader = new JdbcCursorItemReader<>();
        itemReader.setSql("SELECT * FROM Compra"); // Consulta a la tabla Compra
        itemReader.setDataSource(jdbcTemplate.getDataSource()); // Asigna el DataSource
        itemReader.setRowMapper(new BeanPropertyRowMapper<>(Compra.class)); // Mapea cada fila a un objeto Compra
    }

    @Bean
    public JdbcCursorItemReader<Compra> reader() {
        return itemReader;
    }
}
*/