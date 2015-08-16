package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.InscripcionPOJO;

/**
 * Fecha: 16-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 03 Descripción:Esta clase simula un httpservlet, 
 *simula las respuestas al front end.
 */

public class InscripcionResponse extends BaseResponse{

	private List<InscripcionPOJO> inscripciones;
	private InscripcionPOJO inscripcion;
	
	public List<InscripcionPOJO> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(List<InscripcionPOJO> inscripciones) {
		this.inscripciones = inscripciones;
	}
	public InscripcionPOJO getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(InscripcionPOJO inscripcion) {
		this.inscripcion = inscripcion;
	}
}