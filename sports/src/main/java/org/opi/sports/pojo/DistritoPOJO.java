package org.opi.sports.pojo;

/**
 * Fecha: 01-08-2015 version 1.0
 * @author Mauricio Fernández Mora
 *Sprint 04 Descripción: Esta clase es la representación de un objeto "Distrito"
 */

public class DistritoPOJO {

	private int idDistrito;
	private String distrito;
	private String latitud;
	private String longitud;
	
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}
