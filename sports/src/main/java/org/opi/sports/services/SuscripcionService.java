package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Subscripcion;
import org.opi.sports.repositories.ReviewRepository;
import org.opi.sports.repositories.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuscripcionService implements SuscripcionServiceInterface{
	
	@Autowired
	public SuscripcionRepository suscripcionRepository;
	
	@Transactional
	@Override
	public Subscripcion findOne(Integer idSubscripcion) {
		// TODO Auto-generated method stub
		return suscripcionRepository.findOne(idSubscripcion);
	}
	
	@Transactional
	@Override
	public List<Subscripcion> getAll() {
		// TODO Auto-generated method stub
		return suscripcionRepository.findAll();
	}
	
	@Transactional
	@Override
	public <S extends Subscripcion> S save(S subscripcion) {
		// TODO Auto-generated method stub
		return suscripcionRepository.save(subscripcion);
	}
}
