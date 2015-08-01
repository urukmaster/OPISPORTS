package org.opi.sports.services;

import javax.transaction.Transactional;

import org.opi.sports.ejb.Usuario;
import org.opi.sports.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Fecha: 23-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *Sprint #3 Descripción: Usuario que se encarga de comuicarse con el repositorio para
 * las consulta a la base de datos.
 */
@Service
public class UsuarioService implements UsuarioServiceInterface{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findOne(Integer idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}
	
	@Transactional
	public <Usuarios extends Usuario> Usuarios save(Usuarios usuarios) {
		return usuarioRepository.save(usuarios);
	}
	
	/**
	 * Metodo encargado dvalidar si existe el usuario
	 * 
	 */
	
	@Transactional
	@Override
	public boolean exists(Integer idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.exists(idUsuario);
	}

}
