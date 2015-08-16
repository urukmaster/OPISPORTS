package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.EventoResponse;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.contracts.RetoResponse;
import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.contracts.ServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Reto;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.RetoHelper;
import org.opi.sports.helpers.ServicioHelper;
import org.opi.sports.pojo.DistritoPOJO;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.utils.PojoUtils;
//import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
	
	@Autowired
	UsuarioServiceInterface usuarioServices;
	
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
			System.out.println(establecimiento.getNombre());
			if(establecimiento.getActive() == 1){
				System.out.println(establecimiento.getNombre());
				establecimientoViewList.add(EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimiento));
				
			}			
		}
		
		establecimientoResponse.setEstablecimientosDeportivos(establecimientoViewList);
		
		return establecimientoResponse;
	}

	/**
	 *Este método obtiene un establecimiento deportivo
	 *registrado en la base de datos por medio de su id
	 */	
	@RequestMapping(value="getEstablecimiento", method = RequestMethod.POST)
	public EstablecimientoDeportivoResponse getEstablecimiento(@RequestBody int idEstablecimiento){
		
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		
		EstablecimientoDeportivo establecimiento = establecimientoDeportivoService.findOne(idEstablecimiento);
		
		DistritoPOJO distrito = new DistritoPOJO();
		
		PojoUtils.pojoMappingUtility(distrito, establecimiento.getDistrito());
		
		EstablecimientoDeportivoPOJO establecimientoView = new EstablecimientoDeportivoPOJO();
		PojoUtils.pojoMappingUtility(establecimientoView, establecimiento);
		
		establecimientoView.setDistrito(distrito);
		
		establecimientoResponse.setEstablecimientoDeportivo(establecimientoView);
		establecimientoResponse.setIdCanton(establecimiento.getDistrito().getCanton().getIdCanton());
		establecimientoResponse.setIdProvincia(establecimiento.getDistrito().getCanton().getProvincia().getIdProvincia());
		
		return establecimientoResponse;		
		
	}
	
	/**
	 * Metodo de registrar el establecimiento deportivo
	 * 
	 */
	@RequestMapping(value="save" , method = RequestMethod.POST)
	public EstablecimientoDeportivoResponse save(@RequestBody EstablecimientoDeportivoRequest establecimientoRequest){
		//Esatblecimiento response
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		//Establecimiento POJO
		EstablecimientoDeportivoPOJO establecimientoView = EstablecimientoDeportivoHelper.getInstance().saveEstablecimiento(establecimientoRequest, establecimientoDeportivoService);
		
		if(establecimientoDeportivoService.exists(establecimientoView.getIdEstablecimientoDeportivo())){
			List<EstablecimientoDeportivoPOJO> establecimientos = new ArrayList<EstablecimientoDeportivoPOJO>();
			establecimientos.add(establecimientoView);
			establecimientoResponse.setEstablecimientosDeportivos(establecimientos);
			establecimientoResponse.setCode(200);
			establecimientoResponse.setCodeMessage("El establecimiento deportivo se registro correctamente");
		}else{
			establecimientoResponse.setCode(401);
			establecimientoResponse.setCodeMessage("El establecimiento deportivo no se registro");
		}
		return establecimientoResponse;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public EstablecimientoDeportivoPOJO delete(@RequestBody int idEstablecimiento) {

		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		
		EstablecimientoDeportivo establecimiento = establecimientoDeportivoService.findOne(idEstablecimiento);
		establecimiento.setActive((byte) 0);
		
		EstablecimientoDeportivoPOJO establecimientoPOJO = new EstablecimientoDeportivoPOJO();

		establecimientoDeportivoService.save(establecimiento);
		
		PojoUtils.pojoMappingUtility(establecimientoPOJO, establecimiento);

		return establecimientoPOJO;
	}

}
