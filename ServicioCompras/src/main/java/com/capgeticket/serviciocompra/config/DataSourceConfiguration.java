package com.capgeticket.serviciocompra.config;

import javax.sql.DataSource;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
    
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://ep-calm-king-a2ipcv7c-pooler.eu-central-1.aws.neon.tech/capgeticket?user=capgeticket_owner&password=NbtUhiawj41o&sslmode=require");

        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }
}