package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.TiquetePOJO;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 03 Descripción:Esta clase simula un httpservlet, 
 *simula las respuestas al front end.
 */

public class TiqueteResponse extends BaseResponse{

	private List<TiquetePOJO> tiquetes;
	private TiquetePOJO tiquete;

	public TiquetePOJO getTiquete() {
		return tiquete;
	}

	public void setTiquete(TiquetePOJO tiquete) {
		this.tiquete = tiquete;
	}

	public List<TiquetePOJO> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(List<TiquetePOJO> tiquetes) {
		this.tiquetes = tiquetes;
	}
}