package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Tiquete;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 03: Descripción: Esta interfaz sirve para implementar los servicios
 *de tiquetes
 */

public interface TiqueteServiceInterface {

	public List<Tiquete> getAllTiquetes();
	
	public Tiquete findOne(Integer idTiquete);
	
	public <Tiquetes extends Tiquete> Tiquetes save(Tiquetes tiquete);
	
	public boolean exists(Integer idTiquete);
	
	public  List<Tiquete> findByNombreEvento(String nombreEvento);

}


