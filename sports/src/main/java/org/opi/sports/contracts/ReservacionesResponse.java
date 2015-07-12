package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.ReservacionesPOJO;

public class ReservacionesResponse {

	private List<ReservacionesPOJO> Reservaciones;

	public List<ReservacionesPOJO> getReservaciones() {
		return Reservaciones;
	}

	public void setReservaciones(List<ReservacionesPOJO> Reservaciones) {
		this.Reservaciones = Reservaciones;
	}
	
	
	
}
