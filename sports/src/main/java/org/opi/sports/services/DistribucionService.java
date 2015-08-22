package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Distribucion;
import org.opi.sports.repositories.CentroDistribucionRepository;
import org.opi.sports.repositories.DistribucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DistribucionService implements DistribucionServiceInterface {
	
	@Autowired
	public DistribucionRepository distribucionRepository;

	/**
	 * Metodo encaragdo de obtener los centros de distribucion
	 */
	@Transactional
	public List<Distribucion> getAllCentros() {
		try {
			return distribucionRepository.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Metodo encaragado de registrar los centros de distribucion
	 */
	@Transactional
	public <S extends Distribucion> S save(S distribucion) {
		try {
			return distribucionRepository.save(distribucion);
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Metodo encargado de probar si existen los centros de distribucion
	 */
	@Transactional
	public boolean exists(int idDistribucion) {
		try {
			return distribucionRepository.exists(idDistribucion);
		} catch (Exception exception) {
			throw exception;
		}
	}
}
