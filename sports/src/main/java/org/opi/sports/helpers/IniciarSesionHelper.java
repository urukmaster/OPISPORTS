package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Permiso;
import org.opi.sports.ejb.Permisos_Rol;
import org.opi.sports.ejb.Rol;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Usuario_Rol;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.pojo.PermisoPOJO;
import org.opi.sports.pojo.RolPOJO;
import org.opi.sports.pojo.SubscripcionPOJO;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 21-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Helper de iniciar sesión 
 *
 */
public class IniciarSesionHelper {
	
	private static IniciarSesionHelper instance;

	private IniciarSesionHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new IniciarSesionHelper();
		}
	}

	public static IniciarSesionHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}	
	/**
	 * Metodo encargado de covertir Usuario ejb a Usuario POJO
	 * 
	 */
	public UsuarioPOJO convertirUsuario(Usuario pusuario){
		UsuarioPOJO usuarioView = new UsuarioPOJO();
		
		PojoUtils.pojoMappingUtility(usuarioView, pusuario);
		List<SubscripcionPOJO> subscripcionespojou = new ArrayList<SubscripcionPOJO>();
		
		subscripcionespojou = subscripcion(pusuario);
		List<RolPOJO> roles = new ArrayList<RolPOJO>();		

		/*List<InscripcionPOJO> listaInscripciones = new ArrayList<InscripcionPOJO>();*/
	
		for(Usuario_Rol  usuario_rol : pusuario.getUsuarioRols()){
			roles.add(convertirRol(usuario_rol.getRol()));
		}
		
		/*for(Inscripcion inscripcion : pusuario.getInscripcions()){
			listaInscripciones.add(convertirInscripcion(inscripcion));
		}*/
		
		
		usuarioView.setSubscripciones(subscripcionespojou);
		usuarioView.setRoles(roles);
		
		/*usuarioView.setInscripciones(listaInscripciones);*/
		return usuarioView;
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
	
	/**
	 * Metodo encargado de covertir un rol ejb a rol POJO
	 * 
	 */
	private RolPOJO convertirRol(Rol prol){
		RolPOJO rol = new RolPOJO();
		PojoUtils.pojoMappingUtility(rol, prol);
		List<PermisoPOJO> permisos = new ArrayList<PermisoPOJO>();
		for(Permisos_Rol permisorol: prol.getPermisosRols()){
			permisos.add(convertirPermiso(permisorol.getPermiso()));
		}
		rol.setPermisos(permisos);
		return rol;
	}
	
	/**
	 * Metodo encargado de covertir un permiso ejb a permiso POJO
	 * 
	 */
	private PermisoPOJO convertirPermiso(Permiso permiso){
		PermisoPOJO permisoPOJO = new PermisoPOJO();
		PojoUtils.pojoMappingUtility(permisoPOJO, permiso);
		return permisoPOJO;
	}
	
	/**
	 * Metodo encargado de convertir una inscripcion ejb en una inscripcion pojo
	 *//*
	private InscripcionPOJO convertirInscripcion(Inscripcion inscripcion) {
		
		InscripcionPOJO inscripcionpojo = new InscripcionPOJO();
		PojoUtils.pojoMappingUtility(inscripcionpojo, inscripcion);
		
		List<TiquetePOJO> listaTiquetes = new ArrayList<TiquetePOJO>();
		
		for(Tiquete tiquete : inscripcion.getTiquetes()){
			
			if(tiquete.getActive() == 1){
				listaTiquetes.add(convertirTiquete(tiquete));
			}
		}
		
		inscripcionpojo.setListaTiquetes(listaTiquetes);

		return inscripcionpojo;
	}

	
	*//**
	 * Metodo encargado de convertir un tiquete ejb en un tiquete pojo
	 *//*
	private TiquetePOJO convertirTiquete(Tiquete tiquete) {
		
		TiquetePOJO tiquetepojo = new TiquetePOJO();
		PojoUtils.pojoMappingUtility(tiquetepojo, tiquete);

		return tiquetepojo;
	}
	
	*//**
	 * Metodo encargado de convertir un evento ejb en un evento pojo
	 *//*
	private EventoPOJO convertirEvento(Evento evento) {
		
		EventoPOJO eventopojo = new EventoPOJO();
		PojoUtils.pojoMappingUtility(eventopojo, evento);

		return eventopojo;
	}*/
}
