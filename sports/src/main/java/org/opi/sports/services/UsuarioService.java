package org.opi.sports.services;

import javax.transaction.Transactional;

import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Usuario_Rol;
import org.opi.sports.repositories.RolRepository;
import org.opi.sports.repositories.UsuarioRepository;
import org.opi.sports.repositories.IniciarSesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 08-08-2015 version 2.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *         Sprint #3 Descripción: Usuario que se encarga de comuicarse con el
 *         repositorio para las consulta a la base de datos. Incluye integración
 *         de roles.
 */
@Service
public class UsuarioService implements UsuarioServiceInterface {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	RolRepository rolRepository;

	@Autowired
	IniciarSesionRepository ISRepository;

	public Usuario findOne(Integer idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}

	@Transactional
	@Override
	public boolean exists(int idUsuario) {
		try {
			return usuarioRepository.exists(idUsuario);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Transactional
	public <Usuarios extends Usuario> Usuarios save(Usuarios usuarios) {
		try {
			return usuarioRepository.save(usuarios);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Transactional
	public <Roles extends Usuario_Rol> Roles save(Roles roles) {
		try {
			return rolRepository.save(roles);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	@Transactional
	public Usuario ValidarUsuario(UsuarioRequest usuarioRequest) {
		try {
			Usuario prueba = ISRepository
					.findByCorreoAndContrasenna(usuarioRequest.getCorreo(),
							usuarioRequest.getContrasenna());
			return prueba;
		} catch (Exception exception) {
			throw exception;
		}

	}

}
