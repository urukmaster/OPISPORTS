package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.ejb.TipoServicio;

/**
 * Fecha: 29-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *Sprint #5 Descripción: Interface que brinda encapsular los metodos del servicio
 */
public interface ActividadDeportivaServiceInterface {
	
	public List<ActividadDeportiva> getAllActividadDeportiva();
	public <ActividadesDeportivas extends ActividadDeportiva> ActividadesDeportivas save(ActividadesDeportivas actividadDeportiva);
	public boolean exists(Integer idActividadDeportiva);
	public ActividadDeportiva findByOne(Integer actividadDeportiva);

}
