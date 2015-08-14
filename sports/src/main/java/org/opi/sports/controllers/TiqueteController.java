package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.EventoRequest;
import org.opi.sports.contracts.EventoResponse;
import org.opi.sports.contracts.TiqueteRequest;
import org.opi.sports.contracts.TiqueteResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.EventosHelper;
import org.opi.sports.helpers.TiqueteHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.services.InscripcionServiceInterface;
import org.opi.sports.services.TiqueteServiceInterface;
import org.opi.sports.services.UsuarioService;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	EventoServiceInterface eventoServices;
	
	@Autowired
	UsuarioServiceInterface usuarioServices;
	
	@Autowired
	InscripcionServiceInterface inscripcionServices;

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
			tiqueteViewList.add(TiqueteHelper.getInstance().convertirTiquete(tiquete));
		}
		
		tiqueteResponse.setTiquetes(tiqueteViewList);
		
		return tiqueteResponse;
	}

	/**
	 *Este método obtiene una de eventos deportivos
	 *registrados en la base de datos por medio de su id
	 */	
	@RequestMapping(value="getTiquete", method = RequestMethod.POST)
	public TiqueteResponse getTiquete(@RequestBody int idTiquete){
		
		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		
		Tiquete tiquete = tiqueteServices.findOne(idTiquete);
		
		TiquetePOJO tiqueteView = new TiquetePOJO();
		PojoUtils.pojoMappingUtility(tiqueteView, tiquete);
		
		tiqueteResponse.setTiquete(tiqueteView);
		
		return tiqueteResponse;
	}
		
	/**
	 * Metodo de registrar una inscripcion
	 * 
	 */
	@RequestMapping(value="save" , method = RequestMethod.POST)
	public TiqueteResponse save(@RequestBody TiqueteRequest tiqueteRequest){

		TiqueteResponse tiqueteResponse = new TiqueteResponse();
		
		Usuario usuario = usuarioServices.findOne(tiqueteRequest.getUsuario());
		
		Evento evento = eventoServices.findOne(tiqueteRequest.getEvento());
		
		for(int i = 0; i < tiqueteRequest.getCantidad(); i++){

			TiquetePOJO tiqueteView = TiqueteHelper.getInstance().save(tiqueteRequest, tiqueteServices,
					usuario, evento, inscripcionServices);
			
			if(tiqueteServices.exists(tiqueteView.getIdTiquete())){
				List<TiquetePOJO> tiquetes = new ArrayList<TiquetePOJO>();
				tiquetes.add(tiqueteView);
				tiqueteResponse.setTiquetes(tiquetes);
				tiqueteResponse.setCode(200);
				tiqueteResponse.setCodeMessage("La inscripción se registro correctamente");
			}else{
				tiqueteResponse.setCode(401);
				tiqueteResponse.setCodeMessage("La inscripción no se registro");
			}
			
		}
		return tiqueteResponse;
	}

}

