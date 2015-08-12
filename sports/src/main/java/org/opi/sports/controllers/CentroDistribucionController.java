package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.contracts.ActividadDeportivaResponse;
import org.opi.sports.contracts.CentroDistribucionRequest;
import org.opi.sports.contracts.CentroDistribucionResponse;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.contracts.RetoResponse;
import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Reto;
import org.opi.sports.helpers.ActividadDeportivaHelper;
import org.opi.sports.helpers.CentroDistribucionHelper;
import org.opi.sports.helpers.RetoHelper;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.pojo.CentroDistribucionPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.opi.sports.services.CentroDistribucionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 04-08-2015
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint #5 Descripción: Clase controller encargada de obtener todos los centros de distrubucion
 */
@RestController
@RequestMapping(value = "rest/centroDistribucion")
public class CentroDistribucionController {
	
	@Autowired
	CentroDistribucionServiceInterface centroDistribucionService;

	/**
	 * Metodo encargado de obtener todos los centros de distribucion
	 * 
	 */
	@RequestMapping(value ="getAll", method = RequestMethod.GET)
	public CentroDistribucionResponse getAll(){	
		
		
		CentroDistribucionResponse centroDistribucionResponse = new CentroDistribucionResponse();
	
		List<CentroDistribucion> centrosDistribucion = centroDistribucionService.getAllCentros();
	
		List<CentroDistribucionPOJO> centrosDistribucionPOJO = new ArrayList<CentroDistribucionPOJO>();
		
		for(CentroDistribucion centroDistribuciona :centrosDistribucion){
			CentroDistribucionPOJO centroDisPOJO =  new CentroDistribucionPOJO();
			centroDisPOJO = CentroDistribucionHelper.getInstance().convertirCentro(centroDistribuciona);
			if(centroDisPOJO.getActive()==1){
				centrosDistribucionPOJO.add(centroDisPOJO);
			}
		}
		centroDistribucionResponse.setCentrosDistribucion(centrosDistribucionPOJO);
		
		return centroDistribucionResponse;
	}
	/**
	 * Metodo encargado de registrar los centros de distribucion
	 * 
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public CentroDistribucionResponse save(@RequestBody CentroDistribucionRequest centroDistribucionRequest) {
		
		CentroDistribucionResponse centroDistribucionResponse = new CentroDistribucionResponse();
		CentroDistribucionPOJO centroDistribucionPOJO = CentroDistribucionHelper.getInstance().saveCentro(centroDistribucionRequest, centroDistribucionService);
		
		List<CentroDistribucion> centrosDistribucion = centroDistribucionService.getAllCentros();
		List<CentroDistribucionPOJO> centrosDistribucionPOJO = new ArrayList<CentroDistribucionPOJO>();
		for(CentroDistribucion centroDistribuciona :centrosDistribucion){
			CentroDistribucionPOJO centroDisPOJO =  new CentroDistribucionPOJO();
			centroDisPOJO = CentroDistribucionHelper.getInstance().convertirCentro(centroDistribuciona);
			if(centroDisPOJO.getActive()==1){
				centrosDistribucionPOJO.add(centroDisPOJO);
			}
		}
		if(centroDistribucionService.exists(centroDistribucionPOJO.getIdCentroDistribucion())){
			centroDistribucionResponse.setCode(200);
			centroDistribucionResponse.setCodeMessage("El centro de distribucion se registro correctamente");
			centroDistribucionResponse.setCentrosDistribucion(centrosDistribucionPOJO);
		}else{
			centroDistribucionResponse.setCode(401);
			centroDistribucionResponse.setCodeMessage("El centro de distribucion no se registro");
		}
		return centroDistribucionResponse;
	}
	/**
	 * Metodo encargado de modificar los centros de distribucion
	 * 
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public CentroDistribucionResponse update(@RequestBody CentroDistribucionRequest centroRequest) {
		
		CentroDistribucionResponse centroResponse = new CentroDistribucionResponse();
		CentroDistribucionPOJO centropojo = CentroDistribucionHelper.getInstance().updateCentro(centroRequest, centroDistribucionService);
		
		List<CentroDistribucion> centrosDistribucion = centroDistribucionService.getAllCentros();
		List<CentroDistribucionPOJO> centrosDistribucionPOJO = new ArrayList<CentroDistribucionPOJO>();
		
		for(CentroDistribucion centroDistribuciona :centrosDistribucion){
			CentroDistribucionPOJO centroDisPOJO =  new CentroDistribucionPOJO();
			centroDisPOJO = CentroDistribucionHelper.getInstance().convertirCentro(centroDistribuciona);
			if(centroDisPOJO.getActive()==1){
				centrosDistribucionPOJO.add(centroDisPOJO);
			}
		}
		
	if (centroDistribucionService.exists(centropojo.getIdCentroDistribucion())) {
		centroResponse.setCentrosDistribucion(centrosDistribucionPOJO);
		centroResponse.setCode(200);
		centroResponse.setCodeMessage("El reto se modifico correctamente");
	}else{
		centroResponse.setCode(401);
		centroResponse.setCodeMessage("El reto no se modifico");
	}

		return centroResponse;
		
	}
	/**
	 * Metodo encargado de eliminar los centros de distribucion
	 * 
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public CentroDistribucionResponse delete(@RequestBody CentroDistribucionRequest centroRequest) {
		
		CentroDistribucionResponse centroResponse = new CentroDistribucionResponse();
		CentroDistribucionPOJO centropojo = CentroDistribucionHelper.getInstance().deleteCentro(centroRequest, centroDistribucionService);
		
		List<CentroDistribucion> centrosDistribucion = centroDistribucionService.getAllCentros();
		List<CentroDistribucionPOJO> centrosDistribucionPOJO = new ArrayList<CentroDistribucionPOJO>();
		
		for(CentroDistribucion centroDistribuciona :centrosDistribucion){
			CentroDistribucionPOJO centroDisPOJO =  new CentroDistribucionPOJO();
			centroDisPOJO = CentroDistribucionHelper.getInstance().convertirCentro(centroDistribuciona);
			if(centroDisPOJO.getActive()==1){
				centrosDistribucionPOJO.add(centroDisPOJO);
			}
		}
		
	if (centroDistribucionService.exists(centropojo.getIdCentroDistribucion())) {
		centroResponse.setCentrosDistribucion(centrosDistribucionPOJO);
		centroResponse.setCode(200);
		centroResponse.setCodeMessage("El reto se elimino correctamente");
	}else{
		centroResponse.setCode(401);
		centroResponse.setCodeMessage("El reto no se elimino");
	}

		return centroResponse;
		
	}
		
}