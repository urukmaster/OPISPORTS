package org.opi.sports.contracts;

import org.opi.sports.pojo.TipoServicioPOJO;

/**
 * Fecha: 20-07-2015 version 1.0
 *
 * @author Luis ESteban López Ramírez
 *
 *Sprint #4 Se encarga de realizar los request de los tipos de servicios, desde
 *el fornt end.
 */
public class TipoServicioRequest extends BasePagingRequest{

	private TipoServicioPOJO tipoServicio;

	public TipoServicioPOJO getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicioPOJO tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	public String toString(){
		return "TipoServiceRequest [tipoServicio=" + tipoServicio  + "]";
	}
}
