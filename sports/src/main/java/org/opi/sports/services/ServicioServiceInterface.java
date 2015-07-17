package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Servicio;;
public interface ServicioServiceInterface {

	public List<Servicio> findAll();
	public Servicio findOne(Integer idTipoServicio);
	public <S extends Servicio> S save(S servicio);
	
}
