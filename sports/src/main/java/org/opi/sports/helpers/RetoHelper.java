package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.utils.PojoUtils;

public class RetoHelper {
	private static RetoHelper instance;

	private RetoHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new RetoHelper();
		}
	}

	public static RetoHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	public List<RetosPOJO> convertirReto(List<Reto> pretos){
		List<RetosPOJO> retospojo = new ArrayList<RetosPOJO>();
		
		for(Reto reto:pretos){
			RetosPOJO retopojo = new RetosPOJO();
			SimpleDateFormat convertirHora = new SimpleDateFormat("HH:mm");
			SimpleDateFormat convertirFecha = new SimpleDateFormat("dd-MM-yyyy");
			
			retopojo.setIdReto(reto.getIdReto());
			retopojo.setFecha(convertirFecha(convertirFecha.format(reto.getFecha())));
			retopojo.setHora(convertirHora(convertirHora.format(reto.getHora())));
			retopojo.setMensaje(reto.getMensaje());
			retopojo.setIdUsuario(reto.getUsuario().getIdUsuario());
			retopojo.setNombreUsuario(reto.getUsuario().getNombre());
			retopojo.setTelefonoUsuario(reto.getUsuario().getTelefono());
			retopojo.setNombreServicio(reto.getServicio().getServicio());
			retopojo.setPrecioServicio(reto.getServicio().getPrecio());
			retopojo.setNombreEstablecimiento(reto.getServicio().getEstablecimientoDeportivo().getNombre());
			retopojo.setDireccionEstablecimiento(reto.getServicio().getEstablecimientoDeportivo().getDireccion());
			retospojo.add(retopojo);
		}
		
		return retospojo;
	}

	private DateTime convertirFecha(String fecha) {
		 DateTimeFormatter convertirFecha = DateTimeFormat
		.forPattern("dd-MM-yyyy");
		return convertirFecha.parseDateTime(fecha);
	}
	
	private DateTime convertirHora(String hora) {
		 DateTimeFormatter convertirHora = DateTimeFormat
		.forPattern("HH:mm");
		return convertirHora.parseDateTime(hora);
	}
	
//	public ReservacionesPOJO saveReservacion(ReservacionesRequest reservacion,
//			ReservacionesServiceInterface reservacionService, Usuario usuario, Servicio servicio) {
//
//		Reservaciones reservacionEJB = new Reservaciones();
//		reservacionEJB.setFecha(reservacion.getFecha());
//		reservacionEJB.setHora(reservacion.getHora());
//		reservacionEJB.setOcurrencia(reservacion.getOcurrencia());
//		
//		reservacionEJB.setServicio(servicio);
//		reservacionEJB.setUsuario(usuario);
//		
//		ReservacionesPOJO reservacionPOJO = new ReservacionesPOJO();
//
//		PojoUtils.pojoMappingUtility(reservacionPOJO,
//				reservacionService.save(reservacionEJB));
//		
//		return reservacionPOJO;
//	}

}
