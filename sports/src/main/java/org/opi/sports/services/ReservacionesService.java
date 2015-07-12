package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.repositories.ReservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservacionesService implements ReservacionesServiceInterface{

	@Autowired
	public ReservacionesRepository reservacionesRepositorio;
	
	public List<Reservaciones> getAllReservaciones(){
		return reservacionesRepositorio.findAll();
	}
}
