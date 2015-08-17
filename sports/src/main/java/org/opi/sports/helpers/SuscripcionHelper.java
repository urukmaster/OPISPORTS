package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.pojo.ReviewPOJO;
import org.opi.sports.pojo.SubscripcionPOJO;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.ReviewServiceInterface;
import org.opi.sports.services.SuscripcionServiceInterface;
import org.opi.sports.utils.PojoUtils;

public class SuscripcionHelper {

	private static SuscripcionHelper instance;
	
	private SuscripcionServiceInterface suscripcionService;
	
	private SuscripcionHelper(){
	}
	
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new SuscripcionHelper();
		}
	}
	
	public static SuscripcionHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	public SubscripcionPOJO convertirSuscripcion(Subscripcion psuscripcion) {
		
		UsuarioPOJO usuariopojo = new UsuarioPOJO();
		PojoUtils.pojoMappingUtility(usuariopojo, psuscripcion.getUsuario());
		
		SubscripcionPOJO suscripcionpojo = new SubscripcionPOJO();
		PojoUtils.pojoMappingUtility(suscripcionpojo, psuscripcion);
		TipoEventoPOJO tipoEventoPOJO = new TipoEventoPOJO();
		tipoEventoPOJO = convertirTipoEvento(psuscripcion.getTipoEvento());
		suscripcionpojo.setEventopojo(tipoEventoPOJO);
		suscripcionpojo.setUsuario(usuariopojo);

		return suscripcionpojo;
	}
	/**
	 * Metodo encargado de convertir un tipo de evento ejb en un tipo de evento pojo
	 */
	private TipoEventoPOJO convertirTipoEvento(TipoEvento tipoevento) {
		// TODO Auto-generated method stub
		TipoEventoPOJO tipoeventopojo = new TipoEventoPOJO();
		PojoUtils.pojoMappingUtility(tipoeventopojo, tipoevento);
		return tipoeventopojo;
	}
	
	
	public SubscripcionPOJO deleteSuscripcion(SuscripcionServiceInterface suscripcionService, Subscripcion psuscripcion) {		
		psuscripcion.setActive((byte)0);
		SubscripcionPOJO suscripcionPOJO = new SubscripcionPOJO();
		PojoUtils.pojoMappingUtility(suscripcionPOJO,
				suscripcionService.save(psuscripcion));
		return suscripcionPOJO;
	}

	
}
