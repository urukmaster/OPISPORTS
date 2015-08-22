package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Distribucion;

public interface DistribucionServiceInterface {
	
	public List<Distribucion> getAllCentros();
	/**
	 * Metodo encaragdo de salvar los centros de distribucion
	 */
	public <S extends Distribucion> S save(S distribucion);
	/**
	 * Metodo encargado de probar si existen los centros de distribucion
	 */
	public boolean exists(int idDistribucion); 
}
