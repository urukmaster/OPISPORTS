package org.opi.sports.contracts;

import java.util.List;
import org.opi.sports.pojo.ReservacionesPOJO;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 01 Descripción:Esta clase simula un httpservlet, 
 *simula las respuestas al front end.
 */

public class ReservacionesResponse extends BaseResponse{

	private List<ReservacionesPOJO> reservacion;
	private List<String> JSONCalendar;

	public List<ReservacionesPOJO> getReservacion() {
		return reservacion;
	}

	public void setReservacion(List<ReservacionesPOJO> reservacion) {
		this.reservacion = reservacion;
	}

	public List<String> getJSONCalendar() {
		return JSONCalendar;
	}

	public void setJSONCalendar(List<String> JSONCalendar) {
		this.JSONCalendar = JSONCalendar;
	}
}
