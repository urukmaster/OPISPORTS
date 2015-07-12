package org.opi.sports.contracts;

import org.opi.sports.pojo.ReservacionesPOJO;

public class ReservacionesRequest {

	private ReservacionesPOJO Reservaciones;

	public ReservacionesPOJO getReservaciones() {
		return Reservaciones;
	}

	public void setReservaciones(ReservacionesPOJO Reservaciones) {
		this.Reservaciones = Reservaciones;
	}
	
	public String toString(){
		return "TipoServiceRequest [Reservaciones=" + Reservaciones  + "]";
	}
}
