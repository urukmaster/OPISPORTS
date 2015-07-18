package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.TipoServicio;
import org.springframework.data.repository.CrudRepository;


public interface TipoServicioRepository extends CrudRepository<TipoServicio, Integer>{
	
	public List<TipoServicio> findAll();	
	public TipoServicio findOne(Integer idTipoServicio);

}
