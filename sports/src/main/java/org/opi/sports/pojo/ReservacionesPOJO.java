package org.opi.sports.pojo;

import java.sql.Time;
import java.util.Date;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 01 Descripción: Esta clase es la representación de un objeto "Reservacion"
 *
 */
public class ReservacionesPOJO {

	private int idCalendario;
	private Date fecha;
	private Time hora;
	private String estado;
	private TorneoPOJO torneo;
	
	
	public int getIdCalendario() {
		return idCalendario;
	}
	
	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Time getHora() {
		return hora;
	}
	
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public TorneoPOJO getTorneo() {
		return torneo;
	}

	public void setTorneo(TorneoPOJO torneo) {
		this.torneo = torneo;
	}
			
}
