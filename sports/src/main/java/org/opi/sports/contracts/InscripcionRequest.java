package org.opi.sports.contracts;


/**
 * Fecha: 16-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 06 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

public class InscripcionRequest extends BasePagingRequest {
	
	private Integer idInscripcion;
	private Integer idUsuario;
	
	public Integer getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(Integer idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

}
