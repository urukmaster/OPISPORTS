package org.opi.sports.contracts;

import org.opi.sports.pojo.ReservacionesPOJO;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 01 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

public class ReservacionesRequest extends BasePagingRequest{

	private ReservacionesPOJO reservacion;

	public ReservacionesPOJO getReservacion() {
		return reservacion;
	}

	public void setReservacion(ReservacionesPOJO reservacion) {
		this.reservacion = reservacion;
	}
	
	public String toString(){
		return "ReservacionesRequest [reservacion=" + reservacion  + "]";
	}
}
