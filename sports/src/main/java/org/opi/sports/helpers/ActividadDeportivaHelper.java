package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 05 Descripción: Helper de actividades deportivas
 *
 */
public class ActividadDeportivaHelper {
	
	private static ActividadDeportivaHelper instance;
	private ActividadDeportivaServiceInterface ActividadDeportivaService;
	
	private ActividadDeportivaHelper(){
	}
	
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new ActividadDeportivaHelper();
		}
	}
	
	public static ActividadDeportivaHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	/**
	 * Metodo encargado de covertir Actividad Deportiva ejb a Actividad Deportiva POJO
	 * 
	 */
	public ActividadDeportivaPOJO convertirActividadDeportiva(ActividadDeportiva pactividadDeportiva){
		ActividadDeportivaPOJO actividadDeportivaView = new ActividadDeportivaPOJO();
		
		PojoUtils.pojoMappingUtility(actividadDeportivaView, pactividadDeportiva);
		
		return actividadDeportivaView;
	}
	
	/**
	 * Metodo encargado de registrar la actividad deportiva
	 * 
	 */
	public ActividadDeportivaPOJO saveActividadDeportiva(ActividadDeportivaRequest actividadDeportiva,
			ActividadDeportivaServiceInterface actividadDeportivaService) {

		ActividadDeportiva actividadDeportivaEJB = new ActividadDeportiva();
		actividadDeportivaEJB.setActividadDeportiva(actividadDeportiva.getActividadDeportiva());
		actividadDeportivaEJB.setActive((byte)1);
		
		ActividadDeportivaPOJO actividadDeportivaPOJO = new ActividadDeportivaPOJO();
		

		PojoUtils.pojoMappingUtility(actividadDeportivaPOJO,
				actividadDeportivaService.save(actividadDeportivaEJB));
		
		return actividadDeportivaPOJO;
	}
	
	/**
	 * Metodo encargado de actualizar la actividad deportiva
	 * 
	 */
	public ActividadDeportivaPOJO updateActividadDeportiva(ActividadDeportivaRequest actividadDeportiva,
			ActividadDeportivaServiceInterface actividadDeportivaService) {
		
		ActividadDeportiva actividadDeportivaEJB = new ActividadDeportiva();
		actividadDeportivaEJB.setIdActividadDeportiva(actividadDeportiva.getIdActividadDeportiva());
		actividadDeportivaEJB.setActividadDeportiva(actividadDeportiva.getActividadDeportiva());
		actividadDeportivaEJB.setActive((byte)1);
				
		ActividadDeportivaPOJO actividadDeportivaPOJO = new ActividadDeportivaPOJO();

		PojoUtils.pojoMappingUtility(actividadDeportivaPOJO,
				actividadDeportivaService.save(actividadDeportivaEJB));
		
		return actividadDeportivaPOJO;
	}
	
	/**
	 * Metodo encargado de eliminar la actividad deportiva
	 * 
	 */
	public ActividadDeportivaPOJO deleteActividadDeportiva(ActividadDeportivaRequest actividadDeportiva,
			ActividadDeportivaServiceInterface actividadDeportivaService) {
		System.out.println(actividadDeportiva.getActividadDeportiva());
		ActividadDeportiva actividadDeportivaEJB = new ActividadDeportiva();
		actividadDeportivaEJB.setIdActividadDeportiva(actividadDeportiva.getIdActividadDeportiva());
		actividadDeportivaEJB.setActividadDeportiva(actividadDeportiva.getActividadDeportiva());
		actividadDeportivaEJB.setActive((byte) 0);
				
		ActividadDeportivaPOJO actividadDeportivaPOJO = new ActividadDeportivaPOJO();

		PojoUtils.pojoMappingUtility(actividadDeportivaPOJO,
				actividadDeportivaService.save(actividadDeportivaEJB));
		
		return actividadDeportivaPOJO;
	}

}
