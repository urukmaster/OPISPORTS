package org.opi.sports.contracts;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import java.util.List;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase response para los datos solicitados
 *
 */
public class EstablecimientoDeportivoResponse extends BaseResponse {
	// Lista de Establecimientos deportivos POJO
	private List<EstablecimientoDeportivoPOJO> establecimientoDeportivo;
	
	
	/**
	 * Metodo get que devuelve una lista de establecimientos deportivos POJO
	 * 
	 */
	public List<EstablecimientoDeportivoPOJO> getEstablecimientoDeportivo() {
		return establecimientoDeportivo;
	}
	
	/**
	 * Metodo set que modifica una lista de establecimientos deportivos POJO
	 * 
	 */
	public void setEstablecimientoDeportivo(List<EstablecimientoDeportivoPOJO> establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

}
