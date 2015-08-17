package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;



import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.pojo.PermisoPOJO;
import org.opi.sports.pojo.SubscripcionPOJO;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.pojo.TiquetePOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.utils.PojoUtils;
import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.ejb.Permiso;
import org.opi.sports.ejb.Permisos_Rol;
import org.opi.sports.ejb.Rol;
import org.opi.sports.ejb.Usuario_Rol;
import org.opi.sports.pojo.RolPOJO;
import org.opi.sports.services.*;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 03 Descripción: Helper de usuarios
 *
 * * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 03 Descripción: Clase helper del usuario
 *
 */
public class UsuarioHelper {

	private static UsuarioHelper instance;
	private EstablecimientoDeportivoServiceInterface UsuarioService;
	
	private UsuarioHelper(){
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
		
		List<InscripcionPOJO> inscripcionespojou = new ArrayList<InscripcionPOJO>();
		inscripcionespojou = getListaInscripciones(pusuario);
		
		List<SubscripcionPOJO> subscripcionespojou = new ArrayList<SubscripcionPOJO>();
		subscripcionespojou = subscripcion(pusuario);
		
		usuariopojo.setInscripciones(inscripcionespojou);
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
		subscripcionpojo.setEventopojo(convertirTipoEvento(tipoevento));
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
	private List<InscripcionPOJO> getListaInscripciones(Usuario pusuario){
		List<InscripcionPOJO> inscripicionespojo = new ArrayList<InscripcionPOJO>();
		for(Inscripcion inscripcion: pusuario.getInscripcions()){
			inscripicionespojo.add(convertirInscripciones(inscripcion));
		}
		return inscripicionespojo;
	}
	
	/**
	 * Metodo encargado de convertir una inscripcion ejb en una inscripcion pojo
	 */
	private InscripcionPOJO convertirInscripciones(Inscripcion inscripcion) {
		InscripcionPOJO inscripcionpojo = new InscripcionPOJO();
		
		PojoUtils.pojoMappingUtility(inscripcionpojo, inscripcion);
		List<TiquetePOJO> tiquetespojo = new ArrayList<TiquetePOJO>();	
		for(Tiquete tiquete : inscripcion.getTiquetes()){
			tiquetespojo.add(convertirTiquete(tiquete));
		}
		inscripcionpojo.setListaTiquetes(tiquetespojo);
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
	
	/**
	 * Metodo encargado de covertir Usuario ejb a Usuario POJO
	 * 
	 */
	public UsuarioPOJO convertirUsuario(Usuario pusuario){
		UsuarioPOJO usuarioView = new UsuarioPOJO();
		
		PojoUtils.pojoMappingUtility(usuarioView, pusuario);
		
		List<RolPOJO> roles = new ArrayList<RolPOJO>();
	
		for(Usuario_Rol  usuario_rol : pusuario.getUsuarioRols()){
			roles.add(convertirRol(usuario_rol.getRol()));
		}
		usuarioView.setRoles(roles);
		return usuarioView;
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
	 * Metodo encargado de registrar el usuario
	 * 
	 */
	public UsuarioPOJO saveUsuario(UsuarioRequest usuario,
			UsuarioServiceInterface usuarioService) {
		
		
		Usuario usuarioEJB = new Usuario();
		//Inicializacion del Rol
		Rol rolEJB = new Rol();
		rolEJB.setIdRol(1);
			
		//Inicializacion del Usuario
		usuarioEJB.setCorreo(usuario.getCorreo());
		usuarioEJB.setNombre(usuario.getNombre());
		usuarioEJB.setApellido(usuario.getApellido());
		usuarioEJB.setTelefono(usuario.getTelefono());
		usuarioEJB.setContrasenna(usuario.getContrasenna());
		usuarioEJB.setActive((byte)1);
		
		
		UsuarioPOJO usuarioPOJO = new UsuarioPOJO();

		PojoUtils.pojoMappingUtility(usuarioPOJO,
				usuarioService.save(usuarioEJB));
		
		usuarioEJB = usuarioService.ValidarUsuario(usuario);
		
		//Inicializacion del usuarioRol
		Usuario_Rol usuario_rolEJB = new Usuario_Rol();
		usuario_rolEJB.setRol(rolEJB);
		usuario_rolEJB.setUsuario(usuarioEJB);
				
		usuarioService.save(usuario_rolEJB);
		
		return usuarioPOJO;
	}
	
	/**
	 * Metodo encargado de actualizar el usuario
	 * 
	 */
	public UsuarioPOJO updateUsuario(UsuarioRequest usuario,
			UsuarioServiceInterface usuarioService) {

		Usuario usuarioEJB = new Usuario();
		usuarioEJB.setIdUsuario(usuario.getIdUsuario());
		usuarioEJB.setCorreo(usuario.getCorreo());
		usuarioEJB.setNombre(usuario.getNombre());
		usuarioEJB.setApellido(usuario.getApellido());
		usuarioEJB.setTelefono(usuario.getTelefono());
		usuarioEJB.setContrasenna(usuario.getContrasenna());
		usuarioEJB.setActive((byte)1);
		
		UsuarioPOJO usuarioPOJO = new UsuarioPOJO();

		PojoUtils.pojoMappingUtility(usuarioPOJO,
				usuarioService.save(usuarioEJB));
		
		return usuarioPOJO;
	}
}
