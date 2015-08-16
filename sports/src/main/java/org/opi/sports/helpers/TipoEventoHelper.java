package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;


import org.opi.sports.contracts.TipoEventoRequest;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.services.TipoEventoServiceInterface;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 05 Descripción: Helper de actividades deportivas
 */
 
public class TipoEventoHelper {
	
	private static TipoEventoHelper instance;
	private TipoEventoServiceInterface TipoEventoService;
	
	private TipoEventoHelper(){
		
	}
	
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new TipoEventoHelper();
		}
	}
	public static TipoEventoHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	/**
	 * Metodo encargado de covertir Tipo evento ejb a Actividad Deportiva POJO
	 * 
	 */
	public TipoEventoPOJO convertirTipoEvento(TipoEvento ptipoEvento){
		TipoEventoPOJO tipoEventoView = new TipoEventoPOJO();
		
		PojoUtils.pojoMappingUtility(tipoEventoView, ptipoEvento);
		
		return tipoEventoView;
	}
	
	/**
	 * Metodo encargado de registrar el tipo de evento
	 * 
	 */
	public TipoEventoPOJO saveTipoEvento(TipoEventoRequest tipoEvento,
			TipoEventoServiceInterface tipoEventoService) {

		TipoEvento tipoEventoEJB = new TipoEvento();
		tipoEventoEJB.setTipo(tipoEvento.getTipo());
		tipoEventoEJB.setActive((byte)1);
		
		TipoEventoPOJO tipoEventoPOJO = new TipoEventoPOJO();
		

		PojoUtils.pojoMappingUtility(tipoEventoPOJO,
				tipoEventoService.save(tipoEventoEJB));
		
		return tipoEventoPOJO;
	}
	
	/**
	 * Metodo encargado de modificar el tipo de evento
	 * 
	 */
	public TipoEventoPOJO updateTipoEvento(TipoEventoRequest tipoEvento,
			TipoEventoServiceInterface tipoEventoService) {

		TipoEvento tipoEventoEJB = new TipoEvento();
		tipoEventoEJB.setIdTipoEvento(tipoEvento.getIdTipoEvento());
		tipoEventoEJB.setTipo(tipoEvento.getTipo());
		tipoEventoEJB.setActive((byte)1);
		
		TipoEventoPOJO tipoEventoPOJO = new TipoEventoPOJO();
		

		PojoUtils.pojoMappingUtility(tipoEventoPOJO,
				tipoEventoService.save(tipoEventoEJB));
		
		return tipoEventoPOJO;
	}
	
	/**
	 * Metodo encargado de eliminar el tipo de evento
	 * 
	 */
	public TipoEventoPOJO deleteTipoEvento(TipoEventoRequest tipoEvento,
			TipoEventoServiceInterface tipoEventoService) {

		TipoEvento tipoEventoEJB = new TipoEvento();
		tipoEventoEJB.setIdTipoEvento(tipoEvento.getIdTipoEvento());
		tipoEventoEJB.setTipo(tipoEvento.getTipo());
		tipoEventoEJB.setActive((byte)0);
		
		TipoEventoPOJO tipoEventoPOJO = new TipoEventoPOJO();
		

		PojoUtils.pojoMappingUtility(tipoEventoPOJO,
				tipoEventoService.save(tipoEventoEJB));
		
		return tipoEventoPOJO;
	}
}
