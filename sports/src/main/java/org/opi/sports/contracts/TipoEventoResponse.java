package org.opi.sports.contracts;

import org.opi.sports.pojo.TipoEventoPOJO;

import java.util.*;

/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría.
 *
 * Sprint #5 Se encarga de realizar los response de las tipos de eventos, desde el front end.
 */
public class TipoEventoResponse extends BaseResponse {
	
	private List<TipoEventoPOJO> tiposEventos;

	public List<TipoEventoPOJO> getTiposEventos() {
		return tiposEventos;
	}

	public void setTiposEventos(List<TipoEventoPOJO> tiposEventos) {
		this.tiposEventos = tiposEventos;
	}

}
