package org.opi.sports.controllers;



import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.helpers.SuscripcionHelper;
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
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public SubscripcionPOJO delete(@RequestBody int idSubscripcion) {

		Subscripcion subscripcion = suscripcionService.findOne(idSubscripcion);
		SubscripcionPOJO suscripcion = SuscripcionHelper.getInstance().deleteSuscripcion(suscripcionService, subscripcion);

		return suscripcion;
	}
}
