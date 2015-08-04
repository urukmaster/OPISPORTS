package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Provincia;
import org.springframework.data.repository.CrudRepository;


/**
 * Fecha: 02-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 04 Descripción: Esta clase sirve de repositorio para objetos de tipo "Provincia"
 *
 */
public interface ProvinciaRepository extends CrudRepository<Provincia, Integer> {

	public List<Provincia> findAll();
	public Provincia findOne(Integer idProvincia);
	public <Provincias extends Provincia> Provincias save(Provincias provincia);

}
