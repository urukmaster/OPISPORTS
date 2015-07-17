package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Servicio;
import org.springframework.data.repository.CrudRepository;

public interface ServicioRepository extends CrudRepository<Servicio, Integer>{
	
	public List<Servicio> findAll();
	public Servicio findOne(Integer idServicio);
	public <S extends Servicio> S save(S servicio);
	
}
