package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 03: Descripción: Esta interfaza sirve para implementar los servicios
 *de tiquetes
 */

public interface InscripcionServiceInterface {

	public List<Inscripcion> getAllInscripciones();
	
	public Inscripcion findOne(Integer idInscripcion);
	
	public <Inscripciones extends Inscripcion> Inscripciones save(Inscripciones inscripcion);

}
