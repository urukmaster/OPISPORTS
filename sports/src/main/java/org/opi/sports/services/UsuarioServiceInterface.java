package org.opi.sports.services;

import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Usuario_Rol;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *Sprint #4 Descripción: Interface que brinda encapsular los metodos del servicio
 */

public interface UsuarioServiceInterface {

	public Usuario findOne(Integer idUsuario);

	public boolean exists(int idUsuario);

	public <Usuarios extends Usuario> Usuarios save(Usuarios usuarios);
	
	public <Roles extends Usuario_Rol> Roles save(Roles roles);
	
	public Usuario ValidarUsuario(UsuarioRequest usuarioRequest);

}
