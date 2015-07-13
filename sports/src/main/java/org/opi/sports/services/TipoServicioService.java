package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.repositories.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoServicioService implements TipoServicioServiceInterface{

	@Autowired
	public TipoServicioRepository tipoServicioRepositorio;
	
	@Override
	@Transactional
	public List<TipoServicio> getAllTipoServicio(){
		return tipoServicioRepositorio.findAll();
	}
}
