package org.opi.sports.services;

import org.opi.sports.ejb.Usuario;
import org.opi.sports.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UsuarioServiceInterface{
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario findOne(Integer idUsuario) {
		return usuarioRepository.findOne(idUsuario);
	}
	
	

}
