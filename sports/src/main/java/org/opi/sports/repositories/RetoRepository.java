package org.opi.sports.repositories;
import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase repository de los retos
 *
 */
public interface RetoRepository extends CrudRepository<Reto, Integer>{
	/**
	 * Metodo encargado de obtener los retos
	 */
	public List<Reto> findAll();
	/**
	 * Metodo encaragado de registrar el reto
	 */
	public <S extends Reto> S save(S reto);
	/**
	 * Metodo encargado de probar si existe el reto
	 */
	public boolean exists(Integer idReto);
	
}
