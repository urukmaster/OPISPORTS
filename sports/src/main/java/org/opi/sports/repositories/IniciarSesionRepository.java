package org.opi.sports.repositories;
import org.opi.sports.ejb.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 18-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Interface de iniciar sesion
 *
 */
public interface IniciarSesionRepository extends CrudRepository<Usuario,Integer>{
	
	/**
	 * Metodo para buscar un usuario por el correo y la contraseña
	 * 
	 */
	Usuario findByCorreoAndContrasenna(String correo,String contraseña);
	
}

