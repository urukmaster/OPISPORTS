package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Provincia;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 02 Descripción: Esta interfaza sirve para implementar los servicios
 *de eventos deportivos.
 */

public interface ProvinciaServiceInterface {

	public List<Provincia> getAllProvincias();
	
	public <Provincias extends Provincia> Provincias save(Provincias provincia);
	
	public Provincia findOne(Integer idProvincia);

}
