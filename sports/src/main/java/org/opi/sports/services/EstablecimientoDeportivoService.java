package org.opi.sports.services;

import java.util.List;







import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.repositories.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase que implementa la interface de servicios
 *
 */
@Service
public class EstablecimientoDeportivoService implements EstablecimientoDeportivoServiceInterface{
	
	//Variable de tipo de establecimiento repository
	@Autowired
	public EstablecimientoRepository establecimientoDeportivoRepository;

	/**
	 * Metodo que devuelve los establecimientos deportivos por medio del repository
	 * 
	 */
	@Override
	@Transactional
	public List<EstablecimientoDeportivo> getAllEstablecimientos() {
		return establecimientoDeportivoRepository.findAll();
	}
	/**
	 * Metodo encargado de realizar la funcion de registrar el establecimiento repositorio
	 * 
	 */
	@Override
	@Transactional
	public <Estableciminto extends EstablecimientoDeportivo> Estableciminto save(Estableciminto establecimiento) {
		// TODO Auto-generated method stub
		return establecimientoDeportivoRepository.save(establecimiento);
	}
	/**
	 * Metodo encargado de realizar la funcion de buscar por nombre
	 * 
	 */
	@Override
	@Transactional
	public EstablecimientoDeportivo findByName(String pnombre) {
		
		return establecimientoDeportivoRepository.findByNombre(pnombre);
	}
	/**
	 * Metodo encargado dvalidar si existe el establecimiento
	 * 
	 */
	@Transactional
	@Override
	public boolean exists(Integer idEstablecimiento) {
		// TODO Auto-generated method stub
		return establecimientoDeportivoRepository.exists(idEstablecimiento);
	}
	@Transactional
	public EstablecimientoDeportivo findOne(Integer idEstablecimiento) {
		return establecimientoDeportivoRepository.findOne(idEstablecimiento);
	}

}
