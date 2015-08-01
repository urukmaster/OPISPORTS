package org.opi.sports.pojo;

import java.util.List;

public class InscripcionesPOJO {
	
	private int idInscripcion;
	
	private List<TiquetePOJO> tiquetes;

	

	public List<TiquetePOJO> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(List<TiquetePOJO> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	
	
}
