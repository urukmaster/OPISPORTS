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
		

		List<SubscripcionPOJO> subscripciones = new ArrayList<SubscripcionPOJO>();
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
}
