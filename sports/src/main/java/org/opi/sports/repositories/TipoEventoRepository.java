package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.TipoEvento;
import org.springframework.data.repository.CrudRepository;
/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 02 Descripción: Esta clase sirve de repositorio para objetos de tipo "Tipo de evento"
 *
 */

public interface TipoEventoRepository extends CrudRepository<TipoEvento, Integer>{
	
	/**
	 * Metodo que busca las actividades deportivas
	 * 
	 */
	public List<TipoEvento> findAll();	
	
	/**
	 * Metodo que registra la actividad deportiva
	 * 
	 */
	public <S extends TipoEvento> S save(S tipoEvento);

}
