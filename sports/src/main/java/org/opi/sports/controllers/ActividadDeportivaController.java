package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.contracts.ActividadDeportivaResponse;
import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.contracts.UsuarioResponse;
import org.opi.sports.helpers.ActividadDeportivaHelper;
import org.opi.sports.helpers.UsuarioHelper;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 29-07-2015
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #4 Descripción: Se encarga de gestionar las actividades deportivas desde el front
 *end, segun las peticiones por parte de la aplicación.
 */
@RestController
@RequestMapping(value = "rest/actividadDeportiva")
public class ActividadDeportivaController {
	
	@Autowired
	ActividadDeportivaServiceInterface actividadDeportivaService;
	
	/**
	 * Este método se encarga de guardar los usuarios
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ActividadDeportivaResponse save(@RequestBody ActividadDeportivaRequest actividadDeportivaRequest) {
		
		//Actividad Deportiva Response
		ActividadDeportivaResponse actividadDeportivaResponse = new ActividadDeportivaResponse();
		//Actividad Deportiva POJO
		ActividadDeportivaPOJO actividadDeportivaView = ActividadDeportivaHelper.getInstance().saveActividadDeportiva(actividadDeportivaRequest, actividadDeportivaService);
		
		if(actividadDeportivaService.exists(actividadDeportivaView.getIdActividadDeportiva())){
			List<ActividadDeportivaPOJO> actividadesDeportivas = new ArrayList<ActividadDeportivaPOJO>();
			actividadesDeportivas.add(actividadDeportivaView);
			actividadDeportivaResponse.setActividadesDeportivas(actividadesDeportivas);
			actividadDeportivaResponse.setCode(200);
			actividadDeportivaResponse.setCodeMessage("La actividad deportiva se registro correctamente");
		}else{
			actividadDeportivaResponse.setCode(401);
			actividadDeportivaResponse.setCodeMessage("La actividad deportiva no se registro");
		}

		return actividadDeportivaResponse;
		
	}
		
}
