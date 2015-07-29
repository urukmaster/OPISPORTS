package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Servicio;;
public interface ServicioServiceInterface {

	public List<Servicio> findAll();
	public Servicio findOne(Integer idServicio);
	public <Servicios extends Servicio> Servicios save(Servicios servicio);
	
}
