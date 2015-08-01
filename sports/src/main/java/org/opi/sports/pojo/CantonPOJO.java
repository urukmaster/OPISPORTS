package org.opi.sports.pojo;
/**
 * Fecha: 01-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 04 Descripción: Esta clase es la representación de un objeto "Cantón"
 *
 */

public class CantonPOJO {

	private int idCanton;
	private String canton;
	private ProvinciaPOJO idProvincia;
	
	public int getIdCanton() {
		return idCanton;
	}
	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
	}
	public String getCanton() {
		return canton;
	}
	public void setCanton(String canton) {
		this.canton = canton;
	}
	public ProvinciaPOJO getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(ProvinciaPOJO idProvincia) {
		this.idProvincia = idProvincia;
	}

}
