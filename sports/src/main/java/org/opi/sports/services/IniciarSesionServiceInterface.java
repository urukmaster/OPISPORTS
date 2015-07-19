package org.opi.sports.services;

import org.opi.sports.contracts.IniciarSesionRequest;
import org.opi.sports.ejb.Usuario;

/**
 * Fecha: 18-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Interface de servicio de iniciar sesión
 *
 */
public interface IniciarSesionServiceInterface {
	
	/**
	 * Metodo que ofrece el servicio de validar el usuario
	 * 
	 */
	public Usuario ValidarUsuario(IniciarSesionRequest iniciarSesionRequest);
	
}
