package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Usuario;


/**
 * Fecha: 4-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 05 Descripción: Clase interface del centro de distribucion
 *
 */
public interface CentroDistribucionServiceInterface {
	/**
	 * Metodo encaragdo de obtener los centros de distrucion
	 */
	public List<CentroDistribucion> getAllCentros();
	/**
	 * Metodo encaragdo de salvar los centros de distribucion
	 */
	public <S extends CentroDistribucion> S save(S centroDistribucion);
	/**
	 * Metodo encargado de probar si existen los centros de distribucion
	 */
	public boolean exists(int idCentroDistribucion); 
	
	public CentroDistribucion findOne(Integer idCentro);
}
