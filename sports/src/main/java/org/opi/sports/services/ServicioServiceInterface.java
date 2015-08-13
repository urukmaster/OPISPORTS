package org.opi.sports.services;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *Sprint #4 Descripción: Interface que brinda encapsular los metodos del servicio
 */
import java.util.List;

import org.opi.sports.ejb.Servicio;;
public interface ServicioServiceInterface {

	public List<Servicio> findAll();
	public Servicio findOne(Integer idServicio);
	public <Servicios extends Servicio> Servicios save(Servicios servicio);
	
}
