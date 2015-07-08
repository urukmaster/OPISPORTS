package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.TipoServicioResponse;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.pojo.TipoServicioPOJO;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "rest/tipoServicio")
public class TipoServicioController {
	
	@Autowired
	TipoServicioServiceInterface tipoServicioService;

	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public TipoServicioResponse getAll(){
		
		System.out.println("ENTRO!!!!!!!!!!!");
		System.out.println("ENTRO!!!!!!!!!!!");
		System.out.println("ENTRO!!!!!!!!!!!");
		
		TipoServicioResponse tipoServicioResponse = new TipoServicioResponse();
		
		List<TipoServicio> tipoServicioList = tipoServicioService.getAllTipoServicio();
		List<TipoServicioPOJO> tipoServicioViewList = new ArrayList<TipoServicioPOJO>();
		
		for(TipoServicio tipoServicio : tipoServicioList){
			TipoServicioPOJO tipoServicioView = new TipoServicioPOJO();
			PojoUtils.pojoMappingUtility(tipoServicioView, tipoServicio);
			tipoServicioViewList.add(tipoServicioView);
		}
		System.out.println("SALIO!!!!!!!!!!!");
		System.out.println("SALIO!!!!!!!!!!!");
		System.out.println("SALIO!!!!!!!!!!!");
		
		return tipoServicioResponse;
	}
	
}
