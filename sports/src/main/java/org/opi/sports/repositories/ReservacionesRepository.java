package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 01 Descripción: Esta clase sirve de repositorio para obejtos de tipo "Reservacion"
 *
 */
public interface ReservacionesRepository extends CrudRepository<Reservaciones, Integer> {
	
	public List<Reservaciones> findAll();	
	
	public <S extends Reservaciones> S save(S reservacion);
	
	public boolean exists(Integer idReservacion);
	
	public Reservaciones findOne(Integer idReservacion);

}
