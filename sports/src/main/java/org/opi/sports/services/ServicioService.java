package org.opi.sports.services;

import java.util.List;

import javax.transaction.Transactional;

import org.opi.sports.ejb.Servicio;
import org.opi.sports.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *         Sprint #4 Descripción: Servicio que se encarga de comuicarse con el
 *         repositorio para las consulta a la base de datos.
 */
@Service
public class ServicioService implements ServicioServiceInterface {

	@Autowired
	ServicioRepository servicioRepository;

	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;

	@Transactional
	public List<Servicio> findAll() {
		try {
			return servicioRepository.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Transactional
	public Servicio findOne(Integer idServicio) {
		try {
			return servicioRepository.findOne(idServicio);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Transactional
	public <Servicios extends Servicio> Servicios save(Servicios servicio) {
		try {
			return servicioRepository.save(servicio);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
