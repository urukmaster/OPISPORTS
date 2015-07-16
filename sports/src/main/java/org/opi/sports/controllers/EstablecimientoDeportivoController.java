package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@RequestMapping(value = "rest/establecimientoDeportivo")
public class EstablecimientoDeportivoController {
	
	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;
	
	@RequestMapping(value ="getAll", method = RequestMethod.GET)
	public EstablecimientoDeportivoResponse getAll(){	
		
		
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		
		List<EstablecimientoDeportivo> establecimientoList = establecimientoDeportivoService.getAllEstablecimientos();
		List<EstablecimientoDeportivoPOJO> establecimientoViewList = new ArrayList<EstablecimientoDeportivoPOJO>();
		
		
		
		for(EstablecimientoDeportivo establecimiento : establecimientoList){
			establecimientoViewList.add(EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimiento));
		}
		
		establecimientoResponse.setEstablecimientoDeportivo(establecimientoViewList);
		
		return establecimientoResponse;
	}
}
