package org.opi.sports.repositories;

import java.util.List;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.springframework.data.repository.CrudRepository;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Interface del repositorio del establecimiento
 *
 */
public interface EstablecimientoRepository extends CrudRepository<EstablecimientoDeportivo, Integer>{
	
	/**
	 * Metodo que devuelve la lista  de los establecimientos
	 * 
	 */
	public List<EstablecimientoDeportivo> findAll();
	
	/**
	 * Metodo que busca por nombre un establecimiento deportivo
	 * 
	 */
	public EstablecimientoDeportivo findByNombre(String nombre);
	/**
	 * Metodo que registra el establecimiento deportivo
	 * 
	 */
	public <Establecimiento extends EstablecimientoDeportivo> Establecimiento save(Establecimiento establecimiento);
	
	public EstablecimientoDeportivo findOne(Integer idEstablecimiento);
}