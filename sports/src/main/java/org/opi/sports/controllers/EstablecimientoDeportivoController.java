package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.contracts.ReservacionesResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Controllador rest de establecimeintos deportivos encargada
 *de serializar los objetos y devolverlos al front end como recibir json y convertirlos en 
 *objetos java
 *
 */
@RestController
@RequestMapping(value = "rest/establecimientoDeportivo")
public class EstablecimientoDeportivoController {
	
	//Variable de tipo EstablecimientoDeportivoServiceInterface
	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;
	
	@Autowired
	UsuarioServiceInterface usuarioServices;
	
	/**
	 * Metodo encargado de solicitar todos los establecimientos deportivos 
	 * 
	 */
	@RequestMapping(value ="getAll", method = RequestMethod.GET)
	public EstablecimientoDeportivoResponse getAll(){	
		
		//Variable de tipo EstablecimientoDeportivoResponse
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		//Lista de tipo EstablecimientoDeportivo
		List<EstablecimientoDeportivo> establecimientoList = establecimientoDeportivoService.getAllEstablecimientos();
		//Lista de EstablecimientoDeportivoPOJO
		List<EstablecimientoDeportivoPOJO> establecimientoViewList = new ArrayList<EstablecimientoDeportivoPOJO>();
		
		for(EstablecimientoDeportivo establecimiento : establecimientoList){
			establecimientoViewList.add(EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimiento));
		}
		
		establecimientoResponse.setEstablecimientoDeportivo(establecimientoViewList);
		
		return establecimientoResponse;
	}
	/**
	 * Metodo de registrar el establecimiento deportivo
	 * 
	 */
	@RequestMapping(value="save" , method = RequestMethod.POST)
	public EstablecimientoDeportivoResponse save(@RequestBody EstablecimientoDeportivoRequest establecimientoRequest){
		//Esatblecimiento response
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		//Establecimiento POJO
		EstablecimientoDeportivoPOJO establecimientoView = EstablecimientoDeportivoHelper.getInstance().saveEstablecimiento(establecimientoRequest, establecimientoDeportivoService);
		
		if(establecimientoDeportivoService.exists(establecimientoView.getIdEstablecimientoDeportivo())){
			List<EstablecimientoDeportivoPOJO> establecimientos = new ArrayList<EstablecimientoDeportivoPOJO>();
			establecimientos.add(establecimientoView);
			establecimientoResponse.setEstablecimientoDeportivo(establecimientos);
			establecimientoResponse.setCode(200);
			establecimientoResponse.setCodeMessage("El establecimiento deportivo se registro correctamente");
		}else{
			establecimientoResponse.setCode(401);
			establecimientoResponse.setCodeMessage("El establecimiento deportivo no se registro");
		}
		return establecimientoResponse;
	}

}
