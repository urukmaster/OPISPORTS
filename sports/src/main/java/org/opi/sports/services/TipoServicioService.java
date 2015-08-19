package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.repositories.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *         Sprint #3 Descripción: Servicio que se encarga de comuicarse con el
 *         repositorio para las consulta a la base de datos.
 */
@Service
public class TipoServicioService implements TipoServicioServiceInterface {

	@Autowired
	TipoServicioRepository tipoServicioRepositorio;

	@Transactional
	public List<TipoServicio> getAllTipoServicio() {
		try {
			return tipoServicioRepositorio.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Transactional
	public TipoServicio findOne(Integer idTipoServicio) {
		try {
			return tipoServicioRepositorio.findOne(idTipoServicio);
		} catch (Exception exception) {
			throw exception;
		}
	}
}
