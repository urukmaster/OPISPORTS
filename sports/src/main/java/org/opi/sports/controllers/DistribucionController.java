package org.opi.sports.controllers;


import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.DistribucionReponse;
import org.opi.sports.contracts.DistribucionRequest;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.contracts.RetoResponse;
import org.opi.sports.ejb.Reto;
import org.opi.sports.helpers.DistribucionHelper;
import org.opi.sports.helpers.RetoHelper;
import org.opi.sports.pojo.DistribucionPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.CentroDistribucionServiceInterface;
import org.opi.sports.services.DistribucionServiceInterface;
import org.opi.sports.services.EventoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/distribucion")
public class DistribucionController {
	
	@Autowired
	DistribucionServiceInterface distribucionService;
	@Autowired
	CentroDistribucionServiceInterface centroDistribucionService;
	@Autowired
	EventoServiceInterface eventoService;
	
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public DistribucionReponse save(@RequestBody DistribucionRequest distribucionRequest) {
		
		DistribucionReponse distribucionResponse = new DistribucionReponse();

		try {

			DistribucionPOJO distribucionpojo = DistribucionHelper.getInstance().saveDistribucion(
					distribucionService,
					centroDistribucionService.findOne(distribucionRequest.getIdCentroDistribucion()),
					eventoService.findOne(distribucionRequest.getIdEvento()));

			
			if (distribucionService.exists(distribucionpojo.getIdDistribucion())) {
				//distribucionResponse.setRetospojo(retospojo);
				distribucionResponse.setCode(200);
				distribucionResponse.setCodeMessage("El centro se asocio correctamente");
			} else {
				distribucionResponse.setCode(401);
				distribucionResponse.setCodeMessage("El centro no se asocio correctamente");
			}
		} catch (Exception exception) {
			distribucionResponse.setCode(404);
			distribucionResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			distribucionResponse.setErrorMessage(exception.getMessage());
		}

		return distribucionResponse;
	}

}
