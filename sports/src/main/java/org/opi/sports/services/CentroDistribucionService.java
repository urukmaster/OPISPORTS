package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Reto;
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
 *Sprint 05 Descripción: Clase de los servicios del centros de distribucion
 *
 */
@Service
public class CentroDistribucionService implements CentroDistribucionServiceInterface {
	
	@Autowired
	public CentroDistribucionRepository centroDistribucionRepository;
	
	/**
	 * Metodo encaragdo de obtener los centros de distribucion
	 */
	@Transactional
	public List<CentroDistribucion> getAllCentros(){
		return centroDistribucionRepository.findAll();
	}
	/**
	 * Metodo encaragado de registrar los centros de distribucion
	 */
	@Transactional
	@Override
	public <S extends CentroDistribucion> S save(S centroDistribucion) {
		// TODO Auto-generated method stub
		return centroDistribucionRepository.save(centroDistribucion);
	}
	/**
	 * Metodo encargado de probar si existen los centros de distribucion
	 */
	@Transactional
	@Override
	public boolean exists(int idCentroDistribucion) {
		// TODO Auto-generated method stub
		return centroDistribucionRepository.exists(idCentroDistribucion);
	}
}
