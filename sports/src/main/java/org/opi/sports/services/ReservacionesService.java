package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.repositories.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 01 Descripción: Esta clase se encarga de proveer los servicios que el controlador necesita
 *provenientes de los repositorios.
 */
@Service
public class ReservacionesService implements ReservacionesServiceInterface{
	
	@Autowired
	ReservacionesRepository reservacionesRepositorio;

	public List<Reservaciones> getAllReservaciones() {
		return reservacionesRepositorio.findAll();
	}

	public <S extends Reservaciones> S save(S reservacion) {
		return reservacionesRepositorio.save(reservacion);
	}

	public boolean exists(Integer idReservacion) {
		return reservacionesRepositorio.exists(idReservacion);
	}	

}
