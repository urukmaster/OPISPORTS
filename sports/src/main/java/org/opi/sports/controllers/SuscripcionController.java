package org.opi.sports.controllers;



import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.InscripcionResponse;
import org.opi.sports.contracts.SuscripcionResponse;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.helpers.InscripcionHelper;
import org.opi.sports.helpers.SuscripcionHelper;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.pojo.SubscripcionPOJO;
import org.opi.sports.services.SuscripcionServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/suscripcion")
public class SuscripcionController {
	
	@Autowired
	SuscripcionServiceInterface suscripcionService;
	
	
	@RequestMapping(value="getAll", method = RequestMethod.GET)
	public SuscripcionResponse getAll(){
		
		SuscripcionResponse suscripcionResponse = new SuscripcionResponse();
		
		List<Subscripcion> suscripciones = suscripcionService.getAll();
		List<SubscripcionPOJO> suscripcionespojo = new ArrayList<SubscripcionPOJO>();
		
		for(Subscripcion suscripcion : suscripciones){
			SubscripcionPOJO suscripcionpojo = new SubscripcionPOJO();
			suscripcionpojo = SuscripcionHelper.getInstance().convertirSuscripcion(suscripcion);
			if(suscripcionpojo.getActive()==1){
				suscripcionespojo.add(suscripcionpojo);
			}
			
		}
		
		suscripcionResponse.setSuscripciones(suscripcionespojo);
		
		return suscripcionResponse;		
		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public SubscripcionPOJO delete(@RequestBody int idSubscripcion) {

		Subscripcion subscripcion = suscripcionService.findOne(idSubscripcion);
		SubscripcionPOJO suscripcion = SuscripcionHelper.getInstance().deleteSuscripcion(suscripcionService, subscripcion);

		return suscripcion;
	}
}
