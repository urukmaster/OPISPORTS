package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.id.uuid.Helper;
import org.opi.sports.contracts.EventoRequest;
import org.opi.sports.contracts.EventoResponse;
import org.opi.sports.ejb.Evento;
import org.opi.sports.helpers.EventosHelper;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 02 Descripción:Esta clase es la que contendrá cada uno de los servicios que
 *serán necesarios para procesar la información de los eventos deportivos de la aplicación
 */

@RestController
@RequestMapping(value = "rest/evento")

public class EventoController {
	
	@Autowired
	EventoServiceInterface eventoServices;
	
	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeporitvoService;

	/**
	 *Este método obtiene cada una de las instancias de eventos deportivos
	 *registrados en la base de datos
	 */	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public EventoResponse getAll(){
		
		EventoResponse eventoResponse = new EventoResponse();
		
		List<Evento> eventoList = eventoServices.getAllEventos();
		List<EventoPOJO> eventoViewList = new ArrayList<EventoPOJO>();
		
		for(Evento eventos : eventoList){
			EventoPOJO eventoView = new EventoPOJO();
			PojoUtils.pojoMappingUtility(eventoView, eventos);
			
			if(eventos.getActive() == 1){
				eventoViewList.add(eventoView);
			}
		}
		
		eventoResponse.setEventos(eventoViewList);
		eventoResponse.setJSONCalendar(EventosHelper.getInstance().calendarioSerializer(eventoViewList));
		
		return eventoResponse;		
		
	}

	/**
	 *Este método obtiene un evento deportivo
	 *registrado en la base de datos por medio de su id
	 */	
	@RequestMapping(value="getEvento", method = RequestMethod.POST)
	public EventoResponse getEvento(@RequestBody int idEvento){
		
		EventoResponse eventoResponse = new EventoResponse();
		
		Evento evento = eventoServices.findOne(idEvento);
		
		EventoPOJO eventoView = new EventoPOJO();
		PojoUtils.pojoMappingUtility(eventoView, evento);
		
		eventoResponse.setEvento(eventoView);
		
		eventoResponse.setFecha();
		eventoResponse.setHora();
		
		return eventoResponse;		
		
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	@Transactional
	public EventoResponse save(@RequestBody EventoRequest eventoRequest){
		
		EventoResponse eventoResponse = new EventoResponse();
		
		EventoPOJO evento = EventosHelper.getInstance().save(eventoRequest, eventoServices, establecimientoDeporitvoService);
		
		eventoResponse.setEvento(evento);
		
		return eventoResponse;
	}

}

