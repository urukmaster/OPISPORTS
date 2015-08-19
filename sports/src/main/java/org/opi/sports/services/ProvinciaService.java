package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Provincia;
import org.opi.sports.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *         Sprint 02 Descripción: Esta clase se encarga de proveer los servicios
 *         que el controlador necesita provenientes de los repositorios.
 */

@Service
public class ProvinciaService implements ProvinciaServiceInterface {

	@Autowired
	public ProvinciaRepository provinciaRepositorio;

	public List<Provincia> getAllProvincias() {
		try {
			return provinciaRepositorio.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	public <Provincias extends Provincia> Provincias save(Provincias provincia) {
		try {
			return provinciaRepositorio.save(provincia);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public Provincia findOne(Integer idProvincia) {
		try {
			return provinciaRepositorio.findOne(idProvincia);
		} catch (Exception exception) {
			throw exception;
		}
	}

}