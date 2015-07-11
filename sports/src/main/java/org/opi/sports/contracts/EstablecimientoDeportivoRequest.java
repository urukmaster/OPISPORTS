package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;

public class EstablecimientoDeportivoRequest extends BasePagingRequest{
	
	private EstablecimientoDeportivoPOJO EstablecimientoDeportivo;

	public EstablecimientoDeportivoPOJO getEstablecimientoDeportivo() {
		return EstablecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(EstablecimientoDeportivoPOJO establecimientoDeportivo) {
		EstablecimientoDeportivo = establecimientoDeportivo;
	}



}
