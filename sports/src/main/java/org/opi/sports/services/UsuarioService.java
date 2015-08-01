package org.opi.sports.services;

import javax.transaction.Transactional;

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
	@Transactional
	@Override
	public boolean exists(int idUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.exists(idUsuario);
	}
	
	

}
