package org.opi.sports.services;

import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Subscripcion;

public interface SuscripcionServiceInterface {
	
	public Subscripcion findOne(Integer idSubscripcion);
	public <S extends Subscripcion> S save(S subscripcion);
}	
