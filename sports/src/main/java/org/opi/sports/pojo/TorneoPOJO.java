package org.opi.sports.pojo;

import org.joda.time.DateTime;

/**
 * Revision 1.0
 * @author Luis Esteban López Ramírez
 *
 *Sprint 06 Descripción: Se detalla el POJO para los torneos
 *
 */
public class TorneoPOJO {

	private int idTorneo;

	private String torneo;
	
	private int cupos;
	
	private DateTime start;
	
	private DateTime end;
	
	private int horasTorneos;

	public int getIdTorneo() {
		return idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
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

	public int getHorasTorneos() {
		return horasTorneos;
	}

	public void setHorasTorneos(int horasTorneos) {
		this.horasTorneos = horasTorneos;
	}
	
}
