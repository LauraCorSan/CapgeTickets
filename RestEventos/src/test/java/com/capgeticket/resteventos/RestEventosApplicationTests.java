package com.capgeticket.resteventos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;
import com.capgeticket.resteventos.service.EventoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
class RestEventosApplicationTests {

	@Test
	void shouldBeAlwaysTrue() {
		assertThat(true).isTrue();
	}	
	

}