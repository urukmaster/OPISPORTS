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
 *         Sprint #5 Descripción: Tipo Evento que se encarga de comuicarse con
 *         el repositorio para las consulta a la base de datos.
 */
@Service
public class TipoEventoService implements TipoEventoServiceInterface {

	@Autowired
	TipoEventoRepository tipoEventoRepository;

	public List<TipoEvento> getAllTipoEvento() {
		try {
			return tipoEventoRepository.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	public <TiposEventos extends TipoEvento> TiposEventos save(
			TiposEventos tipoEvento) {
		try {
			return tipoEventoRepository.save(tipoEvento);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Override
	public boolean exists(Integer idTipoEvento) {
		try {
			return tipoEventoRepository.exists(idTipoEvento);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
