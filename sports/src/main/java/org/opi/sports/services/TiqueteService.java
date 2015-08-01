package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.repositories.TiqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 02 Descripción: Esta clase se encarga de proveer los servicios que el controlador necesita
 *provenientes de los repositorios.
 */
@Service
public class TiqueteService implements TiqueteServiceInterface{

	@Autowired
	public TiqueteRepository tiqueteRepositorio;

	public List<Tiquete> getAllTiquetes() {
		return tiqueteRepositorio.findAll();
	}

	public Tiquete findOne(Integer idTiquete) {
		return tiqueteRepositorio.findOne(idTiquete);
	}

}