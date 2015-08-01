package org.opi.sports.pojo;

/**
 * Fecha: 01-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 04 Descripción: Esta clase es la representación de un objeto "Distrito"
 *
 */

public class DistritoPOJO {

	private int idDistrito;
	private String distrito;
	private double latitud;
	private double longitud;
	private CantonPOJO idCanton;
	
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
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public CantonPOJO getIdCanton() {
		return idCanton;
	}
	public void setIdCanton(CantonPOJO idCanton) {
		this.idCanton = idCanton;
	}
	

}
