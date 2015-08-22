package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.CalendarioPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.pojo.TorneoPOJO;
import org.opi.sports.pojo.UsuarioPOJO;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 01 Descripción:Esta clase simula un httpservlet, 
 *simula las respuestas al front end.
 */

public class ReservacionesResponse extends BaseResponse{

	private List<ReservacionesPOJO> reservaciones;
	private List<CalendarioPOJO> JSONCalendar;
	private UsuarioPOJO usuario;
	private ServicioPOJO servicio;
	private CalendarioPOJO reservacion;
	private TorneoPOJO torneo;
	
	public List<ReservacionesPOJO> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<ReservacionesPOJO> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public List<CalendarioPOJO> getJSONCalendar() {
		return JSONCalendar;
	}

	public void setJSONCalendar(List<CalendarioPOJO> JSONCalendar) {
		this.JSONCalendar = JSONCalendar;
	}

	public UsuarioPOJO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}

	public ServicioPOJO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioPOJO servicio) {
		this.servicio = servicio;
	}

	public CalendarioPOJO getReservacion() {
		return reservacion;
	}

	public void setReservacion(CalendarioPOJO reservacion) {
		this.reservacion = reservacion;
	}

	public TorneoPOJO getTorneo() {
		return torneo;
	}

	public void setTorneo(TorneoPOJO torneo) {
		this.torneo = torneo;
	}
}
