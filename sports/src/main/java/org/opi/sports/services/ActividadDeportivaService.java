package org.opi.sports.services;

import java.util.List;

import javax.transaction.Transactional;

import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.repositories.ActividadDeportivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Fecha: 29-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *         Sprint #5 Descripción: Actvidad Deportiva que se encarga de
 *         comuicarse con el repositorio para las consulta a la base de datos.
 */
@Service
public class ActividadDeportivaService implements
		ActividadDeportivaServiceInterface {

	@Autowired
	ActividadDeportivaRepository actividadDeportivaRepository;

	public List<ActividadDeportiva> getAllActividadDeportiva() {
		try {
			return actividadDeportivaRepository.findAll();
		} catch (Exception exception) {
			throw exception;
		}
	}

	public <ActividadesDeportivas extends ActividadDeportiva> ActividadesDeportivas save(
			ActividadesDeportivas actividadDeportiva) {
		try {
			return actividadDeportivaRepository.save(actividadDeportiva);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public boolean exists(Integer idActividadDeportiva) {
		try {
			return actividadDeportivaRepository.exists(idActividadDeportiva);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public ActividadDeportiva findByOne(Integer actividadDeportiva) {
		try{
			return actividadDeportivaRepository.findOne(actividadDeportiva);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
