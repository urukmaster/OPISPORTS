package org.opi.sports.services;

import java.util.List;

import javax.transaction.Transactional;

import org.opi.sports.ejb.Servicio;
import org.opi.sports.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService implements ServicioServiceInterface{

	@Autowired
	ServicioRepository servicioRepository;
	
	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;
	
	@Transactional
	public List<Servicio> findAll() {
		return servicioRepository.findAll();
	}

	@Transactional
	public Servicio findOne(Integer idServicio) {
		return servicioRepository.findOne(idServicio);
	}

	@Transactional
	public <Servicios extends Servicio> Servicios save(Servicios servicio) {
		return servicioRepository.save(servicio);
	}

	
	
}
