package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.springframework.data.repository.CrudRepository;


/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 02 Descripción: Esta clase sirve de repositorio para objetos de tipo "Evento"
 *
 */
public interface EventoRepository extends CrudRepository<Evento, Integer> {
/*	
	public List<Evento> findAll();	*/

}
