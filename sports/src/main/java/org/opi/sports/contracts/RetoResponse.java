package org.opi.sports.contracts;

import java.util.List;

import org.joda.time.DateTime;
import org.opi.sports.pojo.RetosPOJO;

/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase response de los retos
 *
 */
public class RetoResponse extends BaseResponse{
	// lista de retos pojo
	private List<RetosPOJO> retospojo;
	
	/**
	 * Metodo get
	 */
	public List<RetosPOJO> getRetospojo() {
		return retospojo;
	}
	/**
	 * Metodo set
	 */
	public void setRetospojo(List<RetosPOJO> retospojo) {
		this.retospojo = retospojo;
	}
}
