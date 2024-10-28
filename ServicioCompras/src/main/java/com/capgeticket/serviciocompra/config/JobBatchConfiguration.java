package com.capgeticket.serviciocompra.config;

import java.util.List;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.capgeticket.serviciocompra.job.EstadisticasItemProcessor;
import com.capgeticket.serviciocompra.job.EstadisticasItemReader;
import com.capgeticket.serviciocompra.job.EstadisticasItemWriter;
import com.capgeticket.serviciocompra.listener.EstadisticaExecutionListener;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
public class JobBatchConfiguration {
    @Bean
    EstadisticaExecutionListener jobExecutionListener() {
        return new EstadisticaExecutionListener();
    }

    @Bean
    public EstadisticasItemReader reader() {
        return new EstadisticasItemReader();
    }

    @Bean
    public EstadisticasItemProcessor processor() {
        return new EstadisticasItemProcessor();
    }

    @Bean
    public EstadisticasItemWriter writer() {
        return new EstadisticasItemWriter();
    }
    @Bean
    public Job estadisticasJob(EstadisticaExecutionListener jobExecutionListener, JobRepository jobRepository, Step estadisticasStep) {
    	return new JobBuilder("estadisticasJob", jobRepository)
    			.incrementer(new RunIdIncrementer())
    			.listener(jobExecutionListener)
    			.start(estadisticasStep)
    			.build();
    }
    
    @Bean
    public Step estadisticasStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    	return new StepBuilder("estadisticasStep", jobRepository)
    			.<Compra, EstadisticasCompra>chunk(100, transactionManager)
    			.reader(reader())
    			.processor(processor())
    			.writer(writer())
    			.build();
    }
}



