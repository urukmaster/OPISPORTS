package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.services.RetoServiceInterface;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase Helper para el reto
 *
 */
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
	/**
	 * Metodo en cargado de convertir los retos a pojo
	 * 
	 */
	public List<RetosPOJO> convertirReto(List<Reto> pretos){
		List<RetosPOJO> retospojo = new ArrayList<RetosPOJO>();
		
		for(Reto reto:pretos){
			if(reto.getActive() == 1 && reto.getServicio().getEstablecimientoDeportivo().getActive() == 1){
				RetosPOJO retopojo = new RetosPOJO();
				SimpleDateFormat convertirHora = new SimpleDateFormat("HH:mm");
				SimpleDateFormat convertirFecha = new SimpleDateFormat("dd-MM-yyyy");	
				retopojo.setIdReto(reto.getIdReto());
				retopojo.setFecha(convertirFecha(convertirFecha.format(reto.getFecha())));
				retopojo.setHora(convertirHora(convertirHora.format(reto.getHora())));
				retopojo.setMensaje(reto.getMensaje());
				retopojo.setIdUsuario(reto.getUsuario().getIdUsuario());
				retopojo.setNombreUsuario(reto.getUsuario().getNombre());
				retopojo.setApellidoUsuario(reto.getUsuario().getApellido());
				retopojo.setTelefonoUsuario(reto.getUsuario().getTelefono());
				retopojo.setIdServicio(reto.getServicio().getIdServicio());
				retopojo.setNombreServicio(reto.getServicio().getServicio());
				retopojo.setPrecioServicio(reto.getServicio().getPrecio());
				retopojo.setIdEstablecimiento(reto.getServicio().getEstablecimientoDeportivo().getIdEstablecimientoDeportivo());
				retopojo.setNombreEstablecimiento(reto.getServicio().getEstablecimientoDeportivo().getNombre());
				retopojo.setDireccionEstablecimiento(reto.getServicio().getEstablecimientoDeportivo().getDireccion());
				retopojo.setActive(reto.getActive());
				retospojo.add(retopojo);
			}
		}
		
		return retospojo;
	}
	
	/**
	 * Metodo encargado de dar formato a la fecha 
	 * 
	 */
	private DateTime convertirFecha(String fecha) {
		 DateTimeFormatter convertirFecha = DateTimeFormat
		.forPattern("dd-MM-yyyy");
		return convertirFecha.parseDateTime(fecha);
	}
	/**
	 * Metodo encargado de dar formato a la hora  
	 * 
	 */
	private DateTime convertirHora(String hora) {
		 DateTimeFormatter convertirHora = DateTimeFormat
		.forPattern("HH:mm");
		return convertirHora.parseDateTime(hora);
	}
	
	/**
	 * Metodo encargado de registrar el reto 
	 * 
	 */
	public RetoPOJO saveReto(RetoRequest reto,
			RetoServiceInterface retoServiceService, Usuario usuario, Servicio servicio) {
		Reto RetoEJB = new Reto();
		RetoEJB.setFecha(reto.getFecha());
		RetoEJB.setHora(reto.getHora());
		RetoEJB.setMensaje(reto.getMensaje());
		RetoEJB.setActive(reto.getActive());
		RetoEJB.setEstado("En espera...");
		
		RetoEJB.setServicio(servicio);
		RetoEJB.setUsuario(usuario);
		
		RetoPOJO retoPOJO = new RetoPOJO();

		PojoUtils.pojoMappingUtility(retoPOJO,retoServiceService.save(RetoEJB));
		
		return retoPOJO;
	}
	
	/**
	 * Metodo Metodo encargado de modificar el reto 
	 * 
	 */
	public RetoPOJO updateReto(RetoRequest reto,
			RetoServiceInterface retoServiceService, Usuario usuario, Servicio servicio) {	
		Reto RetoEJB = new Reto();
		RetoEJB.setIdReto(reto.getIdReto());
		RetoEJB.setFecha(reto.getFecha());
		RetoEJB.setHora(reto.getHora());
		RetoEJB.setMensaje(reto.getMensaje());
		RetoEJB.setActive(reto.getActive());
		RetoEJB.setEstado("En espera...");
		
		RetoEJB.setServicio(servicio);
		RetoEJB.setUsuario(usuario);
		
		RetoPOJO retoPOJO = new RetoPOJO();

		PojoUtils.pojoMappingUtility(retoPOJO,retoServiceService.save(RetoEJB));
		
		return retoPOJO;
	}
	
	/**
	 * Metodo encargado de eliminar el reto 
	 * 
	 */
	public RetoPOJO deleteReto(RetoRequest reto,
			RetoServiceInterface retoServiceService, Usuario usuario, Servicio servicio) {	
		Reto RetoEJB = new Reto();
		RetoEJB.setIdReto(reto.getIdReto());
		RetoEJB.setFecha(reto.getFecha());
		RetoEJB.setHora(reto.getHora());
		RetoEJB.setMensaje(reto.getMensaje());
		RetoEJB.setActive(reto.getActive());
		RetoEJB.setEstado("En espera...");
		
		RetoEJB.setServicio(servicio);
		RetoEJB.setUsuario(usuario);
		
		RetoPOJO retoPOJO = new RetoPOJO();

		PojoUtils.pojoMappingUtility(retoPOJO,retoServiceService.save(RetoEJB));
		
		return retoPOJO;
	}
}
