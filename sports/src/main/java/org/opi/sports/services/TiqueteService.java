package org.opi.sports.services;

import java.util.List;
import org.opi.sports.ejb.Tiquete;
import org.opi.sports.repositories.TiqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *         Sprint 02 Descripción: Esta clase se encarga de proveer los servicios
 *         que el controlador necesita provenientes de los repositorios.
 */
@Service
public class TiqueteService implements TiqueteServiceInterface {

	@Autowired
	public TiqueteRepository tiqueteRepositorio;

	public List<Tiquete> getAllTiquetes() {
		try {
			return tiqueteRepositorio.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	public Tiquete findOne(Integer idTiquete) {
		try {
			return tiqueteRepositorio.findOne(idTiquete);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public boolean exists(Integer idTiquete) {
		try {
			return tiqueteRepositorio.exists(idTiquete);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public <Tiquetes extends Tiquete> Tiquetes save(Tiquetes tiquete) {
		try {
			return tiqueteRepositorio.save(tiquete);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public List<Tiquete> findByNombreEvento(String nombreEvento) {
		return tiqueteRepositorio.findByNombreEvento(nombreEvento);
	}

}