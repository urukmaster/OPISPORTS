package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.contracts.ReservacionesResponse;
import org.opi.sports.contracts.RetoResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.helpers.RetoHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.RetoServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
//import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Fecha: 28-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 
 *
 */
@RestController
@RequestMapping(value = "rest/reto")
public class RetoController {
	
	
	@Autowired
	RetoServiceInterface retoService;
	

	@RequestMapping(value ="getAll", method = RequestMethod.GET)
	public RetoResponse getAll(){	
		
		
		RetoResponse retoResponse = new RetoResponse();
		
		List<Reto> retoList = retoService.getAllRetos();
		
		List<RetosPOJO> retos = new ArrayList<RetosPOJO>();
		
		retos = RetoHelper.getInstance().convertirReto(retoList);
		
		retoResponse.setRetospojo(retos);
		
		return retoResponse;
	}
}
