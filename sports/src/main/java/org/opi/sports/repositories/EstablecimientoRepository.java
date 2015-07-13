package org.opi.sports.repositories;

import java.util.List;


import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.springframework.data.repository.CrudRepository;



public interface EstablecimientoRepository extends CrudRepository<EstablecimientoDeportivo, Integer>{
	public List<EstablecimientoDeportivo> findAll();
}