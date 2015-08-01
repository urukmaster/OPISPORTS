package org.opi.sports.services;

import org.opi.sports.ejb.Usuario;

public interface UsuarioServiceInterface {

	public Usuario findOne(Integer idUsuario);

	public boolean exists(int idUsuario);
}
