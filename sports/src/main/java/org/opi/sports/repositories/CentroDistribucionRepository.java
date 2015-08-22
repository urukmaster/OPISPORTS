package org.opi.sports.repositories;
import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase repository de los retos
 *
 */
public interface CentroDistribucionRepository extends CrudRepository<CentroDistribucion,Integer>{
	/**
	 * Metodo encargado de obtener los retos
	 */
	public List<CentroDistribucion> findAll();
	/**
	 * Metodo encaragado de registrar el reto
	 */
	public <S extends CentroDistribucion> S save(S centroDristribucion);
	/**
	 * Metodo encargado de probar si existe el reto
	 */
	public boolean exists(Integer idCentroDistribucion);
	
	public CentroDistribucion findOne(Integer idCentro);
}