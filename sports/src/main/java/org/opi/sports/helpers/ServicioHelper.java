package org.opi.sports.helpers;

import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;

public class ServicioHelper {

	private static ServicioHelper instance;

	private ServicioHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new ServicioHelper();
		}
	}

	public static ServicioHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	public ServicioPOJO saveServicio(ServicioRequest servicioRequest,
			EstablecimientoDeportivo establecimientoDeportivoEJB,
			TipoServicio tipoServicioEJB, ServicioServiceInterface servicioService) {

		Servicio servicioEJB = new Servicio();

		if(servicioRequest.getAccion().equals("Modificar")){
			servicioEJB.setIdServicio(servicioRequest.getIdServicio());
		}
		
		servicioEJB.setArbitro(servicioRequest.getArbitro());
		servicioEJB.setEstablecimientoDeportivo(establecimientoDeportivoEJB);
		servicioEJB.setHoraApertura(servicioRequest.getHoraApertura());
		servicioEJB.setHoraCierre(servicioRequest.getHoraCierre());
		servicioEJB.setPrecio(servicioRequest.getPrecio());
		servicioEJB.setTipoServicio(tipoServicioEJB);
		servicioEJB.setServicio(servicioRequest.getServicio());

		servicioEJB = servicioService.save(servicioEJB);

		ServicioPOJO servicioPOJO = new ServicioPOJO();

		PojoUtils.pojoMappingUtility(servicioPOJO, servicioEJB);
		
		return servicioPOJO;

	}

}
