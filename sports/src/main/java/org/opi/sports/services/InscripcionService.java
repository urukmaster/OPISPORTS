package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 13-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 06 Descripción: Esta clase se encarga de proveer los servicios que el controlador necesita
 *provenientes de los repositorios.
 */

@Service
public class InscripcionService implements InscripcionServiceInterface{

	@Autowired
	public InscripcionRepository inscripcionRepositorio;

	public List<Inscripcion> getAllInscripciones() {
		return inscripcionRepositorio.findAll();
	}

	public Inscripcion findOne(Integer idInscripcion) {
		return inscripcionRepositorio.findOne(idInscripcion);
	}

	public <Inscripciones extends Inscripcion> Inscripciones save(Inscripciones inscripcion) {
		return inscripcionRepositorio.save(inscripcion);
	}

}