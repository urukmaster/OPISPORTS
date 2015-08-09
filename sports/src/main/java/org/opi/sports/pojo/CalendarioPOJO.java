package org.opi.sports.pojo;

import org.joda.time.DateTime;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 *
 *Sprint #3: Se encarga de especificar las caracteristicas necesarias para el calendario
 */
public class CalendarioPOJO {

	private Integer idCalendario;
	private Integer servicio;
	private String title;
	private DateTime start;
	private DateTime end;
	private String backgroundColor;
	private String borderColor;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DateTime getStart() {
		return start;
	}
	public void setStart(DateTime start) {
		this.start = start;
	}
	public DateTime getEnd() {
		return end;
	}
	public void setEnd(DateTime end) {
		this.end = end;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	
	public String toString(){
		String calendario = "title: '" + getTitle() + "'," +
                "start: '" + getStart() + "'," +
                "backgroundColor: '" + getBackgroundColor() + "'," +
                "borderColor: '" + getBorderColor() + "'";
		return calendario;
	}
	public Integer getIdCalendario() {
		return idCalendario;
	}
	public void setIdCalendario(Integer idCalendario) {
		this.idCalendario = idCalendario;
	}
	public Integer getServicio() {
		return servicio;
	}
	public void setServicio(int servicio) {
		this.servicio = servicio;
	}
	
}
