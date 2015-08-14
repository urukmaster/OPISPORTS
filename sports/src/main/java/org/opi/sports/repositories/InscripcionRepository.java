package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Inscripcion;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 13-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 06 Descripción: Esta clase sirve de repositorio para objetos de tipo "Inscripcion"
 *
 */
public interface InscripcionRepository extends CrudRepository<Inscripcion, Integer> {

	public List<Inscripcion> findAll();
	public Inscripcion findOne(Integer idTiquete);

}
