package org.opi.sports.services;

import java.util.List;


import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.repositories.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EstablecimientoDeportivoService implements EstablecimientoDeportivoServiceInterface{
	
	@Autowired
	public EstablecimientoRepository establecimientoDeportivoRepository;

	@Override
	@Transactional
	public List<EstablecimientoDeportivo> getAllEstablecimientos() {
		return establecimientoDeportivoRepository.findAll();
	}
}
