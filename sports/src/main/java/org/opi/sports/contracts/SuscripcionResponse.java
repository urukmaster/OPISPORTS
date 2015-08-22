package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.SubscripcionPOJO;

public class SuscripcionResponse extends BaseResponse{
	
	private List<SubscripcionPOJO> suscripciones;

	public List<SubscripcionPOJO> getSuscripciones() {
		return suscripciones;
	}
	public void setSuscripciones(List<SubscripcionPOJO> suscripciones) {
		this.suscripciones = suscripciones;
	}
}
