package org.opi.sports.pojo;

/**
 * Fecha: 29-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 05 Descripción: Clase actividad deportiva POJO
 *
 */
public class ActividadDeportivaPOJO {
	// Id de la Actividad Deportiva
	private int idActividadDeportiva;
	
	// Nombre de la Actividad Deportiva
	private String actividadDeportiva;
	
	private byte active;
	
	public int getIdActividadDeportiva() {
		return idActividadDeportiva;
	}

	public void setIdActividadDeportiva(int idActividadDeportiva) {
		this.idActividadDeportiva = idActividadDeportiva;
	}

	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(String actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	

}
