package org.opi.sports.repositories;

import org.opi.sports.ejb.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	public Usuario findOne(Integer idUsuario);
}
