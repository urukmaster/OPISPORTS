package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.TiqueteResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.TiquetesHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.services.TiqueteServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 03 Descripción:Esta clase es la que contendrá cada uno de los servicios que
 *serán necesarios para procesar la información de los tiquetes de eventos de la aplicación
 */

@RestController
@RequestMapping(value = "rest/tiquete")

public class TiqueteController {
	
	@Autowired
	TiqueteServiceInterface tiqueteServices;

	/**
	 *Este método obtiene cada una de las instancias de tiquetes
	 *registrados en la base de datos
	 */	
	@RequestMapping(value ="getAll", method = RequestMethod.GET)
	public TiqueteResponse getAll(){	
		
		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		List<Tiquete> tiqueteList = tiqueteServices.getAllTiquetes();
	      List<TiquetePOJO> tiqueteViewList = new ArrayList<TiquetePOJO>();
		
		for(Tiquete tiquete : tiqueteList){
			tiqueteViewList.add(TiquetesHelper.getInstance().convertirTiquete(tiquete));
		}
		
		tiqueteResponse.setTiquetes(tiqueteViewList);
		
		return tiqueteResponse;
	}

	/**
	 *Este método obtiene una de eventos deportivos
	 *registrados en la base de datos por medio de su id
	 */	
	@RequestMapping(value="getTiquete", method = RequestMethod.GET)
	public TiqueteResponse getTiquete(@RequestParam("id") int idTiquete){
		
		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		
		Tiquete tiquete = tiqueteServices.getTiquete(idTiquete);
		
		tiqueteResponse.setTiquete(tiquete);
		
		return tiqueteResponse;		
		
	}

}

