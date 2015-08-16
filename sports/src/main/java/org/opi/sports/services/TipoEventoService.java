package org.opi.sports.services;

import java.util.List;

import javax.transaction.Transactional;

import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.repositories.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *Sprint #5 Descripción: Tipo Evento que se encarga de comuicarse con el repositorio para
 * las consulta a la base de datos.
 */
@Service
public class TipoEventoService implements TipoEventoServiceInterface {

	@Autowired
	TipoEventoRepository tipoEventoRepository;

	@Override
	public List<TipoEvento> getAllTipoEvento() {
		// TODO Auto-generated method stub
		return tipoEventoRepository.findAll();
	}

	@Override
	public <TiposEventos extends TipoEvento> TiposEventos save(
			TiposEventos tipoEvento) {
		// TODO Auto-generated method stub
		return tipoEventoRepository.save(tipoEvento);
	}

	@Override
	public boolean exists(Integer idTipoEvento) {
		// TODO Auto-generated method stub
		return tipoEventoRepository.exists(idTipoEvento);
	}

	
}
