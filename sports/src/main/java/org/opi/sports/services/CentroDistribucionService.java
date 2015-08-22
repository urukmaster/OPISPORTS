package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.repositories.CentroDistribucionRepository;
import org.opi.sports.repositories.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Fecha: 4-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *         Sprint 05 Descripción: Clase de los servicios del centros de
 *         distribucion
 *
 */
@Service
public class CentroDistribucionService implements
		CentroDistribucionServiceInterface {

	@Autowired
	public CentroDistribucionRepository centroDistribucionRepository;

	/**
	 * Metodo encaragdo de obtener los centros de distribucion
	 */
	@Transactional
	public List<CentroDistribucion> getAllCentros() {
		try {
			return centroDistribucionRepository.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Metodo encaragado de registrar los centros de distribucion
	 */
	@Transactional
	public <S extends CentroDistribucion> S save(S centroDistribucion) {
		try {
			return centroDistribucionRepository.save(centroDistribucion);
		} catch (Exception exception) {
			throw exception;
		}
	}

	/**
	 * Metodo encargado de probar si existen los centros de distribucion
	 */
	@Transactional
	public boolean exists(int idCentroDistribucion) {
		try {
			return centroDistribucionRepository.exists(idCentroDistribucion);
		} catch (Exception exception) {
			throw exception;
		}
	}
	
	@Transactional
	public CentroDistribucion findOne(Integer idCentro) {
		try{
			return centroDistribucionRepository.findOne(idCentro);
		}catch (Exception exception){
			throw exception;
		}
		
	}
}
