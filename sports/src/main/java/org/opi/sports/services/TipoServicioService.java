package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.repositories.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioService implements TipoServicioServiceInterface{

	@Autowired
	public TipoServicioRepository tipoServicioRepositorio;
	
	public List<TipoServicio> getAllTipoServicio(){
		return tipoServicioRepositorio.findAll();
	}
}
