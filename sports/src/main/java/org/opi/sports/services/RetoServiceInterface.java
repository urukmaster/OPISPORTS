package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;

public interface RetoServiceInterface {
	public List<Reto> getAllRetos();
	public <S extends Reto> S save(S reto); 
}
