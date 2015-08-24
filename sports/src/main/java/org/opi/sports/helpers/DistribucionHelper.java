package org.opi.sports.helpers;

import java.util.List;

import org.opi.sports.contracts.DistribucionRequest;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Distribucion;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.DistribucionPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.services.DistribucionServiceInterface;
import org.opi.sports.services.RetoServiceInterface;
import org.opi.sports.utils.PojoUtils;

public class DistribucionHelper {
	
	private static DistribucionHelper instance;

	private DistribucionHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new DistribucionHelper();
		}
	}

	public static DistribucionHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	public DistribucionPOJO saveDistribucion(
			DistribucionServiceInterface distribucionServiceService, CentroDistribucion centroDistrubucion, Evento evento) {
		DistribucionPOJO distribucionPOJO = new DistribucionPOJO();
		

				Distribucion DitribucionEJB = new Distribucion();
				DitribucionEJB.setCentroDistribucion(centroDistrubucion);
				DitribucionEJB.setEvento(evento);
				DitribucionEJB.setActive((byte)1);
				PojoUtils.pojoMappingUtility(distribucionPOJO,distribucionServiceService.save(DitribucionEJB));

		
		
		return distribucionPOJO;
	}


}
