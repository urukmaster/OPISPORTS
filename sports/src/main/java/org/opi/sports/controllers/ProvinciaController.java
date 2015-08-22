package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ProvinciaResponse;
import org.opi.sports.ejb.Provincia;
import org.opi.sports.helpers.ProvinciaHelper;
import org.opi.sports.pojo.ProvinciaPOJO;
import org.opi.sports.services.ProvinciaServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 02-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 04 Descripción: Controllador rest de provincias encargada
 *de serializar los objetos y devolverlos al front end como recibir json y convertirlos en 
 *objetos java
 *
 */

@RestController
@RequestMapping(value = "rest/provincia")
public class ProvinciaController {
	
	@Autowired
	ProvinciaServiceInterface provinciaService;
		
	/**
	 * Metodo encargado de solicitar todos las provincias
	 * 
	 */
	@RequestMapping(value ="getAll", method = RequestMethod.GET)
	public ProvinciaResponse getAll(){	
		
		ProvinciaResponse provinciaResponse = new ProvinciaResponse();

		try{
		
		List<Provincia> provinciaList = provinciaService.getAllProvincias();

		List<ProvinciaPOJO> provinciaViewList = new ArrayList<ProvinciaPOJO>();
		
		for(Provincia provincia : provinciaList){
			provinciaViewList.add(ProvinciaHelper.getInstance().convertirProvincia(provincia));
		}
		
		provinciaResponse.setProvincias(provinciaViewList);
		provinciaResponse.setCode(200);
		provinciaResponse.setCodeMessage("Operación exitosa");
		}catch(Exception exception){
			provinciaResponse.setCode(404);
			provinciaResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			provinciaResponse.setErrorMessage(exception.getMessage());
		}
		
		return provinciaResponse;
	}

}