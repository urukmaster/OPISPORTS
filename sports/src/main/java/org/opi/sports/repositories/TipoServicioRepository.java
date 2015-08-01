package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.TipoServicio;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *Sprint #4 Descripción: Repositorio que se encarga de hacer las consulta a
 *la base de datos.
 */
public interface TipoServicioRepository extends CrudRepository<TipoServicio, Integer>{
	
	public List<TipoServicio> findAll();	
	public TipoServicio findOne(Integer idTipoServicio);

}
