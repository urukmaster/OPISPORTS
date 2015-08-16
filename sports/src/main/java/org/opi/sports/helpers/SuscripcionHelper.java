package org.opi.sports.helpers;

import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.pojo.ReviewPOJO;
import org.opi.sports.pojo.SubscripcionPOJO;
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
	
	public SubscripcionPOJO deleteSuscripcion(SuscripcionServiceInterface suscripcionService, Subscripcion psuscripcion) {		
		psuscripcion.setActive((byte)0);
		SubscripcionPOJO suscripcionPOJO = new SubscripcionPOJO();
		PojoUtils.pojoMappingUtility(suscripcionPOJO,
				suscripcionService.save(psuscripcion));
		return suscripcionPOJO;
	}

	
}
