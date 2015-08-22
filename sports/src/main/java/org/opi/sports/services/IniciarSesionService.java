package org.opi.sports.services;

import org.opi.sports.contracts.IniciarSesionRequest;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.repositories.IniciarSesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 18-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *         Sprint 02 Descripción: Clase que implementa el servicio de la
 *         interface
 *
 */
@Service
public class IniciarSesionService implements IniciarSesionServiceInterface {

	// Variable tipo Iniciar sesion repository
	@Autowired
	IniciarSesionRepository iniciarSesionRepository;

	/**
	 * Metodo que valida el usuario por correo y contraseña
	 * 
	 */
	@Override
	public Usuario ValidarUsuario(IniciarSesionRequest iniciarSesionRequest) {
		try {
			return iniciarSesionRepository.findByCorreoAndContrasenna(
					iniciarSesionRequest.getCorreo(),
					iniciarSesionRequest.getContrasenna());
		} catch (Exception exception) {
			throw exception;
		}
	}

}
