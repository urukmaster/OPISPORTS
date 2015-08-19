package org.opi.sports.services;

import org.opi.sports.ejb.Torneo;
import org.opi.sports.repositories.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TorneoService implements TorneoServiceInterface {

	@Autowired
	TorneoRepository torneoRepository;

	public <Torneos extends Torneo> Torneos save(Torneos torneos) {
		try {
			return torneoRepository.save(torneos);
		} catch (Exception exception) {
			throw exception;
		}
	}

	public Torneo findOne(Integer idTorneo) {
		try {
			return torneoRepository.findOne(idTorneo);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
