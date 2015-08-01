package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.InscripcionesPOJO;
import org.opi.sports.pojo.PermisoPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.pojo.SubscripcionPOJO;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.utils.PojoUtils;
/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 03 Descripción: Clase helper del usuario
 *
 */
public class UsuarioHelper {
	private static UsuarioHelper instance;

	private UsuarioHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new UsuarioHelper();
		}
	}

	public static UsuarioHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	/**
	 * Metodo encargado de convertir un usuario ejb en un usuario pojo
	 */
	public UsuarioPOJO perfilUsuario(Usuario pusuario) {
		UsuarioPOJO usuariopojo = new UsuarioPOJO();
		PojoUtils.pojoMappingUtility(usuariopojo, pusuario);
		
		List<InscripcionesPOJO> inscripicionespojou = new ArrayList<InscripcionesPOJO>();
		inscripicionespojou = inscripcion(pusuario);
		
		List<SubscripcionPOJO> subscripcionespojou = new ArrayList<SubscripcionPOJO>();
		subscripcionespojou = subscripcion(pusuario);
		
		usuariopojo.setInscripciones(inscripicionespojou);
		usuariopojo.setSubscripciones(subscripcionespojou);
		return usuariopojo;

	}
	/**
	 * Metodo encargado de convertir una suscripcion ejb en una lista de suscripciones pojo
	 */
	private List<SubscripcionPOJO> subscripcion(Usuario pusuario) {
		List<SubscripcionPOJO> subscripcionespojo= new ArrayList<SubscripcionPOJO>();
		for(Subscripcion subscripcion : pusuario.getSubscripcions()){
			subscripcionespojo.add(convertirSubscripcion(subscripcion));
		}
		return subscripcionespojo;
	}
	/**
	 * Metodo encargado de convertir una suscripcion ejb en una suscripciones pojo
	 */
	private SubscripcionPOJO convertirSubscripcion(Subscripcion subscripcion) {
		// TODO Auto-generated method stub
		SubscripcionPOJO subscripcionpojo = new SubscripcionPOJO();
		PojoUtils.pojoMappingUtility(subscripcionpojo, subscripcion);
		TipoEvento tipoevento = subscripcion.getTipoEvento();
		subscripcionpojo.setEventospojo(convertirTipoEvento(tipoevento));
		return subscripcionpojo;
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
//----------------------------------------------------------------------------------------------------
	/**
	 * Metodo encargado de devolver una lista de inscripciones pojo
	 */
	private List<InscripcionesPOJO> inscripcion(Usuario pusuario){
		List<InscripcionesPOJO> inscripicionespojo = new ArrayList<InscripcionesPOJO>();
		for(Inscripcion inscripcion: pusuario.getInscripcions()){
			inscripicionespojo.add(convertirInscripciones(inscripcion));
		}
		return inscripicionespojo;
	}
	/**
	 * Metodo encargado de convertir una inscripcion ejb en una inscripcion pojo
	 */
	private InscripcionesPOJO convertirInscripciones(Inscripcion inscripcion) {
		InscripcionesPOJO inscripcionpojo = new InscripcionesPOJO();
		
		PojoUtils.pojoMappingUtility(inscripcionpojo, inscripcion);
		List<TiquetePOJO> tiquetespojo = new ArrayList<TiquetePOJO>();	
		for(Tiquete tiquete : inscripcion.getTiquetes()){
			tiquetespojo.add(convertirTiquete(tiquete));
		}
		inscripcionpojo.setTiquetes(tiquetespojo);
		return inscripcionpojo;
	}
	/**
	 * Metodo encargado de convertir un tiquete ejb en un tiquete pojo
	 */
	private TiquetePOJO convertirTiquete(Tiquete tiquete) {
		TiquetePOJO tiquetepojo = new TiquetePOJO();
		PojoUtils.pojoMappingUtility(tiquetepojo, tiquete);
		tiquetepojo.setIdEvento(convertirEvento(tiquete.getEvento()));
		return tiquetepojo;
	}
	/**
	 * Metodo encargado de convertir unevento ejb en un evento pojo pojo
	 */
	private EventoPOJO convertirEvento(Evento evento) {
		EventoPOJO eventopojo = new EventoPOJO();
		PojoUtils.pojoMappingUtility(eventopojo, evento);
		return eventopojo;
	}
}
