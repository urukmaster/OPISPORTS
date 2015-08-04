package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.ActividadDeportiva;
import org.springframework.data.repository.CrudRepository;

public interface ActividadDeportivaRepository extends CrudRepository<ActividadDeportiva, Integer> {
	
	/**
	 * Metodo que busca las actividades deportivas
	 * 
	 */
	public List<ActividadDeportiva> findAll();	
	
	/**
	 * Metodo que registra la actividad deportiva
	 * 
	 */
	public <S extends ActividadDeportiva> S save(S actividadDeportiva);

}
