package org.opi.sports.contracts;

import org.opi.sports.pojo.ActividadDeportivaPOJO;

import java.util.*;

/**
 * Fecha: 29-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría.
 *
 * Sprint #4 Se encarga de realizar los response de las actividades deportivas, desde el front end.
 */

public class ActividadDeportivaResponse extends BaseResponse{
	
	private List<ActividadDeportivaPOJO> actividadesDeportivas;

	public List<ActividadDeportivaPOJO> getActividadesDeportivas() {
		return actividadesDeportivas;
	}

	public void setActividadesDeportivas(
			List<ActividadDeportivaPOJO> actividadesDeportivas) {
		this.actividadesDeportivas = actividadesDeportivas;
	}
	
	

}
