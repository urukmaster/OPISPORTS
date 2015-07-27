package org.opi.sports.services;

import java.util.List;
import org.opi.sports.ejb.Tiquete;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 03: Descripción: Esta interfaza sirve para implementar los servicios
 *de tiquetes
 */

public interface TiqueteServiceInterface {

	public List<Tiquete> getAllTiquetes();
	
	public Tiquete getTiquete(int id);

}
