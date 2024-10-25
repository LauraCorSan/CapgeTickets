package com.capgeticket.serviciocompra.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.capgeticket.job.EstadisticasItemProcessor;
import com.capgeticket.job.EstadisticasItemReader;
import com.capgeticket.job.EstadisticasItemWriter;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableBatchProcessing
@Slf4j
public class JobBatchConfiguration {

   
//
//
//	  
//
//	    @Bean
//	    public EstadisticasItemReader reader() {
//	        return new EstadisticasItemReader(); // Aquí iría la lógica para leer objetos de tipo Compra
//	    }
//
//	    @Bean
//	    public EstadisticasItemProcessor processor() {
//	        return new EstadisticasItemProcessor(); // Procesa objetos Compra y genera EstadisticasCompra
//	    }
//
//	    @Bean
//	    public EstadisticasItemWriter writer() {
//	        return new EstadisticasItemWriter(); // Guarda objetos EstadisticasCompra en la base de datos
//	    }
//
//
//
//	    @Bean
//	    public Step step(ItemReader<Compra> reader, ItemProcessor<Compra, EstadisticasCompra> processor, ItemWriter<EstadisticasCompra> writer, JobRepository jobRepository) {
//	            return new StepBuilder("myStep",jobRepository)
//	                .<Compra, EstadisticasCompra>chunk(10)
//	                .reader(reader)
//	                .processor(processor)
//	                .writer(writer)
//	                .build();
//	    
//}
//	    @Bean
//	    public Job job(Step step, ItemReader<Compra> reader, ItemProcessor<Compra, EstadisticasCompra> processor, ItemWriter<EstadisticasCompra> writer, JobRepository jobRepository) {
//	    	return new JobBuilder("myJob",jobRepository)
//	    			.incrementer(new RunIdIncrementer())
//	    			.flow(reader, processor, writer))
//	    			.end()
//	    			.build();
//	    }
}
