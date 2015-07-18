package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 02 Descripción: Esta clase se encarga de proveer los servicios que el controlador necesita
 *provenientes de los repositorios.
 */
@Service
public class EventoService implements EventoServiceInterface{
	/*
	@Autowired
	public EventoRepository eventoRepositorio;

	public List<Evento> getAllEventos() {
		return eventoRepositorio.findAll();
	}	*/

}
