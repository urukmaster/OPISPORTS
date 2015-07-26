package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.contracts.UsuarioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Permiso;
import org.opi.sports.ejb.Permisos_Rol;
import org.opi.sports.ejb.Rol;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Usuario_Rol;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.PermisoPOJO;
import org.opi.sports.pojo.RolPOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.utils.PojoUtils;
import org.opi.sports.services.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 03 Descripción: Helper de usuarios
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
		usuarioEJB.setCorreo(usuario.getUsuario().getCorreo());
		usuarioEJB.setNombre(usuario.getUsuario().getNombre());
		usuarioEJB.setApellido(usuario.getUsuario().getApellido());
		usuarioEJB.setTelefono(usuario.getUsuario().getTelefono());
		
		
		UsuarioPOJO usuarioPOJO = new UsuarioPOJO();

		PojoUtils.pojoMappingUtility(usuarioPOJO,
				usuarioService.save(usuarioEJB));
		
		return usuarioPOJO;
	}
}
