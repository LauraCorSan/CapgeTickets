package com.capgeticket.resteventos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.resteventos.adapter.EventoAdapter;
import com.capgeticket.resteventos.model.Evento;
import com.capgeticket.resteventos.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired EventoAdapter eventoAdapter;

	/**
     * Llama al repositorio de evento para realizar la operacion de guardado
     *
     * @param Recibe un objeto de tipo Evento
     * @return Resultado de la llamada al metodo save en repositorio
     */
	@Override
	public Evento aniadirEvento(Evento evento) {
		return eventoRepository.save(evento);
	}
}
