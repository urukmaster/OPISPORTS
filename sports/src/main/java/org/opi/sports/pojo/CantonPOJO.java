package org.opi.sports.pojo;

import java.util.List;

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
	private List<DistritoPOJO> listaDistritos;
	
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
	public List<DistritoPOJO> getListaDistritos() {
		return listaDistritos;
	}
	public void setListaDistritos(List<DistritoPOJO> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

}
