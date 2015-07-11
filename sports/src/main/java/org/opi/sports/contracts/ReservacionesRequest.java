package org.opi.sports.contracts;

import org.opi.sports.pojo.ReservacionesPOJO;;

public class ReservacionesRequest {

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
