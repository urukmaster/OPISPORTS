package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.utils.PojoUtils;

public class EstablecimientoDeportivoHelper {
	
	private static EstablecimientoDeportivoHelper instance;

	private EstablecimientoDeportivoHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new EstablecimientoDeportivoHelper();
		}
	}

	public static EstablecimientoDeportivoHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	public EstablecimientoDeportivoPOJO convertirEstablecimiento(
			EstablecimientoDeportivo establecimiento) {

		EstablecimientoDeportivoPOJO establecimientoView = new EstablecimientoDeportivoPOJO();
		
		PojoUtils.pojoMappingUtility(establecimientoView, establecimiento);
		
		List<ServicioPOJO> servicios = new ArrayList<ServicioPOJO>();
		
		for(Servicio servicio: establecimiento.getServicios()){
			servicios.add(convertirServicios(servicio));
		}
		establecimientoView.setServicios(servicios);
		establecimientoView.setCalendario();
		return establecimientoView;

	}

	private ServicioPOJO convertirServicios(Servicio servicio) {

		ServicioPOJO servicioView = new ServicioPOJO();
		PojoUtils.pojoMappingUtility(servicioView, servicio);
		
		List<ReservacionesPOJO> reservaciones = new ArrayList<ReservacionesPOJO>();
		
		for(Reservaciones reservacion : servicio.getReservaciones()){
			reservaciones.add(convertirReservaciones(reservacion));
		}
		
		servicioView.setReservaciones(reservaciones);
		
		return servicioView;
	}

	private ReservacionesPOJO convertirReservaciones(Reservaciones reservacion) {
		
		ReservacionesPOJO reservacionesPOJO = new ReservacionesPOJO();
		PojoUtils.pojoMappingUtility(reservacionesPOJO, reservacion);
		
		return reservacionesPOJO;
	}

}
