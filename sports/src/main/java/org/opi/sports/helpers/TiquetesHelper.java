package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 03 Descripción:Esta clase sirve de apoyo a la clase de
 *         TiquetesController y contiene la lógica necesaria para
 *         serializar los tiquetes y poder mostrarlas en el front end Esta
 *         clase se implementa como "Singleton" para asegurarnos que sea
 *         instanciada una sola vez.
 */


public class TiquetesHelper {

	private static TiquetesHelper instance;

	private TiquetesHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new TiquetesHelper();
		}
	}

	public static TiquetesHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	public TiquetePOJO convertirTiquete(Tiquete tiquete) {

		TiquetePOJO tiqueteView = new TiquetePOJO();
		
		PojoUtils.pojoMappingUtility(tiqueteView, tiquete);
		return tiqueteView;

	}

}
