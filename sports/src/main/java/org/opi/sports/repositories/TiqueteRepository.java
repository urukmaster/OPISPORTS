package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.ejb.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 02 Descripción: Esta clase sirve de repositorio para objetos de tipo "Tiquete"
 *
 */
public interface TiqueteRepository extends CrudRepository<Tiquete, Integer> {

	public List<Tiquete> findAll();
	public Tiquete findOne(Integer idTiquete);
	public <Tiquetes extends Tiquete> Tiquetes save(Tiquetes evento);
	
	/**
	 * Metodo para buscar tiquetes por el id del evento
	 */
	List<Tiquete> findByNombreEvento(String nombreEvento);

}
