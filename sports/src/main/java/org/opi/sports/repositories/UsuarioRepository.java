package org.opi.sports.repositories;

/**
 * Fecha: 23-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #3 Descripción: Esta clase sirve de repositorio para obejtos de tipo "Usuario"
 *
 */

import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Usuario_Rol;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	/**
	 * Metodo que busca un usuario
	 * 
	 */
	public Usuario findOne(Integer idUsuario);
	
	/**
	 * Metodo que registra el usuario
	 * 
	 */
	public <S extends Usuario> S save(S usuario);
	
	/**
	 * Metodo para buscar un usuario por el correo y la contraseña
	 * 
	 */
	Usuario findByCorreoAndContrasenna(String correo,String contraseña);
	
}
