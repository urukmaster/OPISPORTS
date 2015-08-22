package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.ActividadDeportiva;
import org.springframework.data.repository.CrudRepository;
/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 02 Descripción: Esta clase sirve de repositorio para objetos de tipo "Actividad Deportiva"
 *
 */
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
	
	
	public ActividadDeportiva findOne(Integer actividadDeportiva);

}
