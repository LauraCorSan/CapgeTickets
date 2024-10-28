package com.capgeticket.serviciocompra.service;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgeticket.feignclients.BancoFeignClient;
import com.capgeticket.feignclients.EventosFeignClient;
import com.capgeticket.resteventos.response.EventoResponse;
import com.capgeticket.serviciocompra.adapter.CompraAdapter;
import com.capgeticket.serviciocompra.model.Compra;
import com.capgeticket.serviciocompra.error.PeticionCompraIncorrectaException;
import com.capgeticket.serviciocompra.error.ReciboCompraIncorrectaException;
import com.capgeticket.serviciocompra.error.SistemaBancoInestableException;
import com.capgeticket.serviciocompra.response.CompraConfirmadaResponse;
import com.capgeticket.serviciocompra.response.PeticionCompraResponse;

import jakarta.transaction.Transactional;

import com.capgeticket.serviciocompra.repository.CompraRepository;

import com.capgeticket.serviciocompra.response.CompraResponse;
import com.capgeticket.serviciocompra.response.DatosCompraResponse;
import com.capgeticket.serviciocompra.response.ReciboCompraResponse;

import feign.FeignException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Clase: CompraServiceImpl Descripción: clase de servicio que utiliza el
 * repositorio para la gestion de datos de Compras Versión: 2.0 Autores: Laura
 * Gregorio, Laura Cordero, Elena, Guillermo, Veronica
 */
@Transactional
@Service
public class CompraServiceImpl  {


}