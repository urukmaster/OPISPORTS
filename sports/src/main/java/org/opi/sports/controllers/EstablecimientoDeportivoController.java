package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.TipoServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.pojo.TipoServicioPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import scala.annotation.meta.setter;

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
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public EstablecimientoDeportivoResponse create(@RequestBody EstablecimientoDeportivoRequest establecimientoRequest){//ur	
		
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();//us
		
		//HttpSession currentSession = request.getSession();
		//int idUser = (int) currentSession.getAttribute("idUser");
		
		EstablecimientoDeportivo establecimientoDeportivo = new EstablecimientoDeportivo();
		establecimientoDeportivo.setNombre(establecimientoRequest.getEstablecimiento().getNombre());
		establecimientoDeportivo.setDireccion(establecimientoRequest.getEstablecimiento().getDireccion());
		establecimientoDeportivo.setPaginaWeb(establecimientoRequest.getEstablecimiento().getPaginaWeb());
		establecimientoDeportivo.setTelefono(establecimientoRequest.getEstablecimiento().getTelefono());
		//establecimientoDeportivo.setIdUsuario();
		
		Boolean state = establecimientoDeportivoService.saveEstablecimiento(establecimientoDeportivo);
		if(state){
			establecimientoResponse.setCode(200);
			establecimientoResponse.setCodeMessage("Establecimiento creado sastifactoriamente");
		}
		return establecimientoResponse;
		
	}
}
