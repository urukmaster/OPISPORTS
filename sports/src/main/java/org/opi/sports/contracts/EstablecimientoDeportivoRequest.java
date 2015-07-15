package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase request para la solicitud de infromación
 *
 */
public class EstablecimientoDeportivoRequest extends BasePagingRequest{
	
	//Variable de tipo EstablecimientoDeportivoPOJO
	private EstablecimientoDeportivoPOJO EstablecimientoDeportivo;

	
	/**
	 * Metodo get que devuelve el establecimiento deportivo request
	 * 
	 */
	public EstablecimientoDeportivoPOJO getEstablecimientoDeportivo() {
		return EstablecimientoDeportivo;
	}
	
	/**
	 * Metodo set que devumodifica elve el establecimiento deportivo request
	 * 
	 */
	public void setEstablecimientoDeportivo(EstablecimientoDeportivoPOJO establecimientoDeportivo) {
		EstablecimientoDeportivo = establecimientoDeportivo;
	}
	
	/**
	 * Metodo toString que devuelve una cadena de Strings
	 * 
	 */
	@Override
	public String toString() {
		return "EstablecimientoDeportivoRequest [EstablecimientoDeportivo="
				+ EstablecimientoDeportivo + "]";
	}
	
}
