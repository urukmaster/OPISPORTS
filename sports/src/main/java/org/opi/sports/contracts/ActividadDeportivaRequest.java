package org.opi.sports.contracts;

/**
 * Fecha: 29-07-2015 version 1.0
 *
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #5 Se encarga de realizar los request de las actividades deportivas, desde el fornt end.
 *
 */
public class ActividadDeportivaRequest extends BasePagingRequest {
	
	public int idActividadDeportiva;
	
	public String actividadDeportiva;
	
	
	public ActividadDeportivaRequest(){
		super();
	}
	
	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(String actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public int getIdActividadDeportiva() {
		return idActividadDeportiva;
	}

	public void setIdActividadDeportiva(int idActividadDeportiva) {
		this.idActividadDeportiva = idActividadDeportiva;
	}
	
	
	
	

}
