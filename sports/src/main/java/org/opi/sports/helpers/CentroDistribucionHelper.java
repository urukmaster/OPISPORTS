package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.contracts.CentroDistribucionRequest;
import org.opi.sports.contracts.CentroDistribucionResponse;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.pojo.CentroDistribucionPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.opi.sports.services.CentroDistribucionServiceInterface;
import org.opi.sports.services.RetoServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Fecha: 04-08-2015
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint #5 Descripción: Clase helper encargada de los centros de distribucion
 */
public class CentroDistribucionHelper {
	
	
	private static CentroDistribucionHelper instance;
	
	private CentroDistribucionServiceInterface centroDistribucionService;
	
	private CentroDistribucionHelper(){
	}
	
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new CentroDistribucionHelper();
		}
	}
	
	public static CentroDistribucionHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	/**
	 * Metodo encargado de convertir todos los centros de distribucion
	 * 
	 */
	public CentroDistribucionPOJO convertirCentro(CentroDistribucion centroDistribucion){
		CentroDistribucionPOJO centroDistribucionPOJO = new CentroDistribucionPOJO();
		PojoUtils.pojoMappingUtility(centroDistribucionPOJO, centroDistribucion);
		return centroDistribucionPOJO;
	}
	/**
	 * Metodo encargado de registrar el centro de distribucion
	 * 
	 */
	public CentroDistribucionPOJO saveCentro(CentroDistribucionRequest centroDistribucionRequest,
			CentroDistribucionServiceInterface centroDistribucionService) {
		
		List<CentroDistribucion> centros = centroDistribucionService.getAllCentros();
		boolean yaExiste = false;
		CentroDistribucion centroDistribucionEJB = new CentroDistribucion();
		CentroDistribucionPOJO centroDistribucionPOJO = new CentroDistribucionPOJO();

			centroDistribucionEJB.setNombre(centroDistribucionRequest.getNombre()); 
			centroDistribucionEJB.setDireccion(centroDistribucionRequest.getDireccion());
			centroDistribucionEJB.setTelefono(centroDistribucionRequest.getTelefono());
			centroDistribucionEJB.setCorreo(centroDistribucionRequest.getCorreo()); 
			centroDistribucionEJB.setActive((byte)1);
			PojoUtils.pojoMappingUtility(centroDistribucionPOJO,
					centroDistribucionService.save(centroDistribucionEJB));
	
		
		return centroDistribucionPOJO;
	}
	/**
	 * Metodo encargado de modificar el centro de distribucion
	 * 
	 */
	public CentroDistribucionPOJO updateCentro(CentroDistribucionRequest centroRequest,
			CentroDistribucionServiceInterface centroService) {	
		
		CentroDistribucion centroDistribucionEJB = new CentroDistribucion();
		centroDistribucionEJB.setIdCentroDistribucion(centroRequest.getIdCentroDistribucion());
		centroDistribucionEJB.setNombre(centroRequest.getNombre()); 
		centroDistribucionEJB.setDireccion(centroRequest.getDireccion());
		centroDistribucionEJB.setTelefono(centroRequest.getTelefono());
		centroDistribucionEJB.setCorreo(centroRequest.getCorreo()); 
		centroDistribucionEJB.setActive((byte)1);
		
		CentroDistribucionPOJO centroDistribucionPOJO = new CentroDistribucionPOJO();
		
		PojoUtils.pojoMappingUtility(centroDistribucionPOJO,
				centroService.save(centroDistribucionEJB));
		
		return centroDistribucionPOJO;
	}
	
	/**
	 * Metodo encargado de eliminar el centro de distribucion
	 * 
	 */
	public CentroDistribucionPOJO deleteCentro(CentroDistribucionRequest centroRequest,
			CentroDistribucionServiceInterface centroService) {	
		
		CentroDistribucion centroDistribucionEJB = new CentroDistribucion();
		centroDistribucionEJB.setIdCentroDistribucion(centroRequest.getIdCentroDistribucion());
		centroDistribucionEJB.setNombre(centroRequest.getNombre()); 
		centroDistribucionEJB.setDireccion(centroRequest.getDireccion());
		centroDistribucionEJB.setTelefono(centroRequest.getTelefono());
		centroDistribucionEJB.setCorreo(centroRequest.getCorreo()); 
		centroDistribucionEJB.setActive((byte)0);
		
		CentroDistribucionPOJO centroDistribucionPOJO = new CentroDistribucionPOJO();
		
		PojoUtils.pojoMappingUtility(centroDistribucionPOJO,
				centroService.save(centroDistribucionEJB));
		
		return centroDistribucionPOJO;
	}
}
