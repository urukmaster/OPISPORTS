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
	private List<EstablecimientoDeportivoPOJO> establecimientosDeportivos;
	// Establecimiento deportivo POJO
	private EstablecimientoDeportivoPOJO establecimientoDeportivo;

	private int idCanton;
	private int idProvincia;
	
	/**
	 * Metodo get que devuelve una lista de establecimientos deportivos POJO
	 * 
	 */
	public List<EstablecimientoDeportivoPOJO> getEstablecimientosDeportivos() {
		return establecimientosDeportivos;
	}

	/**
	 * Metodo set que modifica una lista de establecimientos deportivos POJO
	 */
	
	public void setEstablecimientosDeportivos(
			List<EstablecimientoDeportivoPOJO> establecimientosDeportivos) {
		this.establecimientosDeportivos = establecimientosDeportivos;
	}
	
	public EstablecimientoDeportivoPOJO getEstablecimientoDeportivo() {
		return establecimientoDeportivo;
	}
	
	public void setEstablecimientoDeportivo(
			EstablecimientoDeportivoPOJO establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}	
	public int getIdCanton() {
		return idCanton;
	}

	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

}
