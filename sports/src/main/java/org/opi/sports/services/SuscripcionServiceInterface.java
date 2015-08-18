package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Subscripcion;

public interface SuscripcionServiceInterface {
	
	public List<Subscripcion> getAll();
	public Subscripcion findOne(Integer idSubscripcion);
	public <S extends Subscripcion> S save(S subscripcion);
}	
