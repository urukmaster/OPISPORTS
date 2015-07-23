package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.TipoServicioPOJO;

/**
 * Fecha: 20-07-2015 version 1.0
 *
 * @author Luis ESteban López Ramírez
 *
 *Sprint #4 Se encarga de realizar los request de los tipos de servicios, desde
 *el fornt end.
 *
 */
public class TipoServicioResponse extends BaseResponse{

	private List<TipoServicioPOJO> tipoServicio;

	public List<TipoServicioPOJO> getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(List<TipoServicioPOJO> tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
}
