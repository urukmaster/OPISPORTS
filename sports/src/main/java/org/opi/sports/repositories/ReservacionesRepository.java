package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.springframework.data.repository.CrudRepository;


public interface ReservacionesRepository extends CrudRepository<Reservaciones, Integer>{
	
	public List<Reservaciones> findAll();

}
