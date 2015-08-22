package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Distribucion;
import org.springframework.data.repository.CrudRepository;

public interface DistribucionRepository extends CrudRepository<Distribucion , Integer> {
	public List<Distribucion> findAll();
	/**
	 * Metodo encaragado de registrar el reto
	 */
	public <S extends Distribucion> S save(S distribucion);
	/**
	 * Metodo encargado de probar si existe el reto
	 */
	public boolean exists(Integer idDistribucion);
}
