package org.opi.sports.contracts;

import org.opi.sports.pojo.TipoServicioPOJO;

public class TipoServicioRequest {

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
