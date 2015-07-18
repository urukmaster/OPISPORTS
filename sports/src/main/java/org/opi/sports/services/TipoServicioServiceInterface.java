package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.TipoServicio;

public interface TipoServicioServiceInterface {

	public List<TipoServicio> getAllTipoServicio();
	public TipoServicio findOne(Integer idTipoServicio);
}
