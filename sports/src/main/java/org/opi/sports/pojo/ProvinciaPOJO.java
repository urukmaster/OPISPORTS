package org.opi.sports.pojo;

import java.util.List;

/**
 * Fecha: 01-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 04 Descripción: Esta clase es la representación de un objeto "Provincia"
 *
 */

public class ProvinciaPOJO {

	private int idProvincia;
	private String provincia;
	private List<CantonPOJO> listaCantones;
	
	public List<CantonPOJO> getListaCantones() {
		return listaCantones;
	}
	public void setListaCantones(List<CantonPOJO> listaCantones) {
		this.listaCantones = listaCantones;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
}
