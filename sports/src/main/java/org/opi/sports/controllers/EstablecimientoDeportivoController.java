package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.TipoServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.TipoServicioPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
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
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	@Transactional
	public EstablecimientoDeportivoResponse getAll(@RequestBody EstablecimientoDeportivoRequest establecimientoRequest){	
		
		establecimientoRequest.setPageNumber(establecimientoRequest.getPageNumber() - 1);
		Page<EstablecimientoDeportivo> establecimientos = establecimientoDeportivoService.findAll(establecimientoRequest);
		
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		
		establecimientoResponse.setCode(200);
		establecimientoResponse.setCodeMessage("establecimientos fetch success");
		establecimientoResponse.setTotalElements(establecimientos.getTotalElements());
		establecimientoResponse.setTotalPages(establecimientos.getTotalPages());

		List<EstablecimientoDeportivoPOJO> viewEstablecimientos = new ArrayList<EstablecimientoDeportivoPOJO>();
		
		establecimientos.getContent().forEach(e->{
			EstablecimientoDeportivoPOJO nestablecimiento = new EstablecimientoDeportivoPOJO();
			nestablecimiento.setNombre(e.getNombre());
			nestablecimiento.setCorreo(e.getCorreo());
			nestablecimiento.setIdEstablecimientoDeportivo(e.getIdEstablecimientoDeportivo());
			nestablecimiento.setTelefono(e.getTelefono());
			nestablecimiento.setDireccion(e.getDireccion());
			viewEstablecimientos.add(nestablecimiento);
		});
		
		establecimientoResponse.setEstablecimientoDeportivo(viewEstablecimientos);
		return establecimientoResponse;		
	}
}
