package com.capgeticket.serviciocompra.config;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.capgeticket.job.EstadisticasItemReader;
import com.capgeticket.serviciocompra.listener.EstadisticasItemProcessListener;
import com.capgeticket.serviciocompra.listener.EstadisticasItemReaderListener;
import com.capgeticket.serviciocompra.listener.EstadisticasItemWriterListener;
import com.capgeticket.serviciocompra.model.EstadisticasCompra;



@Configuration
@EnableBatchProcessing
public class JobBatchConfiguration {
	
	public JobRepository jobRepository ;
    public PlatformTransactionManager transactionManager;
	
    // Job
    @Bean
    	EstadisticasItemReader reader() {
        return new EstadisticasItemReader();
    }

    @Bean
	    EstadisticasItemProcessor processor() { //clase comentada
	        return new EstadisticasItemProcessor(); //clase comentada
	    }

    @Bean
	    EstadisticasItemWriter writer() { //clase comentada
	        return new EstadisticasItemWriter(); //clase comentada
	    }
	
	

    // Listener
    @Bean
    EstadisticasItemProcessListener estadisticasItemProcessListener() {
    	return new EstadisticasItemProcessListener();
    }
    
    
    @Bean
    EstadisticasItemReaderListener estadisticasItemReaderListener() {
    	return new EstadisticasItemReaderListener();
    }
    
    @Bean
    EstadisticasItemWriterListener estadisticasItemWriterListener() {
    	return new EstadisticasItemWriterListener();
    }
	
    
    // Definición del Job


    // Definición del Step
    @Bean
    Step step(EstadisticasItemReader reader,
    		EstadisticasItemWriter writer,  //clase comentada
    		EstadisticasItemProcessor processor,//clase comentada
    		EstadisticasItemReaderListener readerListener,
    		EstadisticasItemProcessListener estadisticasItemProcessListener,
    		EstadisticasItemWriterListener writerListener) {

        return new StepBuilder("step1", jobRepository)
                .<EstadisticasCompra>chunk(100, transactionManager) //falta argumento
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(estadisticasItemProcessListener)
                .listener(writerListener)
                .build();
    }
	

}
