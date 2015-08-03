package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.Reto;
import org.opi.sports.repositories.RetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase de los servicios del reto 
 *
 */
@Service
public class RetoService implements RetoServiceInterface {
	
	@Autowired
	public RetoRepository retoRepository;
	
	/**
	 * Metodo encaragdo de obtener retos
	 */
	@Transactional
	public List<Reto> getAllRetos(){
		return retoRepository.findAll();
	}
	/**
	 * Metodo encaragado de registrar los retos
	 */
	@Transactional
	@Override
	public <S extends Reto> S save(S reto) {
		// TODO Auto-generated method stub
		return retoRepository.save(reto);
	}
	/**
	 * Metodo encargado de probar si existen los retos
	 */
	@Transactional
	@Override
	public boolean exists(int idReto) {
		// TODO Auto-generated method stub
		return retoRepository.exists(idReto);
	}
}
