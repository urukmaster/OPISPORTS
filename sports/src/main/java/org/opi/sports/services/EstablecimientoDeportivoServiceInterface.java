package org.opi.sports.services;

import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.springframework.data.domain.Page;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Interface que define metos para los servicios
 *
 */
public interface EstablecimientoDeportivoServiceInterface {
	
	/**
	 * Metodo que brinda la funcion de devolver los establecimientos deportivos 
	 * 
	 */
	public List<EstablecimientoDeportivo> getAllEstablecimientos();
	/**
	 * Metodo que brinda la funcion de registrar un establecimiento deportivo 
	 * 
	 */
	Boolean saveEstablecimiento(EstablecimientoDeportivo establecimientoDeportivo); 
	
	/**
	 * Metodo que brinda la funcion de buscar por nombre un establecimiento deportivo 
	 * 
	 */
	public EstablecimientoDeportivo findByName(String pnombre);
}
