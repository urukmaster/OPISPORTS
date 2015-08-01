package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reto;
import org.opi.sports.repositories.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class RetoService implements RetoServiceInterface {
	
	@Autowired
	public RetoRepository retoRepository;
	
	@Transactional
	public List<Reto> getAllRetos(){
		return retoRepository.findAll();
	}
	@Transactional
	@Override
	public <S extends Reto> S save(S reto) {
		// TODO Auto-generated method stub
		return retoRepository.save(reto);
	}
}
