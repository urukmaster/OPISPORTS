package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 01 Descripción: Esta interfaza sirve para implementar los servicios
 *de reservaciones.
 */

public interface ReservacionesServiceInterface {

	public List<Reservaciones> getAllReservaciones();	
	public <S extends Reservaciones> S save(S reservacion);
	public boolean exists(Integer idReservacion);
	public Reservaciones findOne(Integer idReservacion);
}
