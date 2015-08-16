package org.opi.sports.repositories;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Subscripcion;
import org.springframework.data.repository.CrudRepository;

public interface SuscripcionRepository extends CrudRepository<Subscripcion, Integer> {
	public Subscripcion findOne(Integer idSubscripcion);
	public <S extends Subscripcion> S save(S subscripcion);
}
