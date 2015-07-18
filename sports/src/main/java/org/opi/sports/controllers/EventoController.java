package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EventoResponse;
import org.opi.sports.ejb.Evento;
import org.opi.sports.helpers.EventosHelper;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
/*	
	@Autowired
	EventoServiceInterface eventoServices;

	*//**
	 *Este método obtiene cada una de las instancias de eventos deportivos
	 *registrados en la base de datos
	 *//*	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public EventoResponse getAll(){
		
		EventoResponse eventoResponse = new EventoResponse();
		
		List<Evento> eventoList = eventoServices.getAllEventos();
		List<EventoPOJO> eventoViewList = new ArrayList<EventoPOJO>();
		
		for(Evento eventos : eventoList){
			EventoPOJO eventoView = new EventoPOJO();
			PojoUtils.pojoMappingUtility(eventoView, eventos);
			eventoViewList.add(eventoView);
		}
		
		eventoResponse.setEvento(eventoViewList);
		eventoResponse.setJSONCalendar(EventosHelper.getInstance().calendarioSerializer(eventoViewList));
		
		return eventoResponse;		
		
	}*/

}
