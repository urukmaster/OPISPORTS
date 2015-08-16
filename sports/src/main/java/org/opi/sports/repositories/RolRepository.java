package org.opi.sports.repositories;

/**
 * Fecha: 08-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #3 Descripción: Esta clase sirve de repositorio para obejtos de tipo "Usuario_Rol"
 *
 */

import org.opi.sports.ejb.Usuario_Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Usuario_Rol,Integer> {
	
	/**
	 * Metodo que registra el usuario
	 * 
	 */
	public <S extends Usuario_Rol> S save(S rol);

}
