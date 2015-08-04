package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase interface del servicio
 *
 */
public interface RetoServiceInterface {
	/**
	 * Metodo encaragdo de obtener los retos
	 */
	public List<Reto> getAllRetos();
	/**
	 * Metodo encaragdo de salvar los retos
	 */
	public <S extends Reto> S save(S reto);
	/**
	 * Metodo encargado de probar si existen los retos
	 */
	public boolean exists(int idReto); 
}
