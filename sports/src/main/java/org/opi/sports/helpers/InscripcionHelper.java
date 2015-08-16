package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 16-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *Sprint 06 Descripción:Esta clase sirve de apoyo a la clase de
 *InscripcionController, esta clase se implementa
 *como "Singleton" para asegurarnos que sea instanciada una sola vez.
 */

public class InscripcionHelper {

	private static InscripcionHelper instance;

	private InscripcionHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new InscripcionHelper();
		}
	}

	public static InscripcionHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	/**
	 * Metodo encargado de convertir una inscripcion ejb en una inscripcion pojo
	 */
	public InscripcionPOJO convertirInscripcion(Inscripcion inscripcion) {
		
		UsuarioPOJO usuariopojo = new UsuarioPOJO();
		PojoUtils.pojoMappingUtility(usuariopojo, inscripcion.getUsuario());
		
		InscripcionPOJO inscripcionpojo = new InscripcionPOJO();
		PojoUtils.pojoMappingUtility(inscripcionpojo, inscripcion);
		
		List<TiquetePOJO> listaTiquetes = new ArrayList<TiquetePOJO>();
		
		for(Tiquete tiquete : inscripcion.getTiquetes()){
			
			if(tiquete.getActive() == 1){
				
				listaTiquetes.add(convertirTiquete(tiquete));
			}
		}
		
		inscripcionpojo.setListaTiquetes(listaTiquetes);
		inscripcionpojo.setUsuario(usuariopojo);

		return inscripcionpojo;
	}
	
	/**
	 * Metodo encargado de convertir un tiquete ejb en un tiquete pojo
	 */
	private TiquetePOJO convertirTiquete(Tiquete tiquete) {
		
		TiquetePOJO tiquetepojo = new TiquetePOJO();
		PojoUtils.pojoMappingUtility(tiquetepojo, tiquete);

		return tiquetepojo;
	}
}