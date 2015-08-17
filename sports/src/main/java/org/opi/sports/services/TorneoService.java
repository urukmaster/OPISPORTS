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
		return torneoRepository.save(torneos);
	}

	public Torneo findOne(Integer idTorneo) {
		return torneoRepository.findOne(idTorneo);
	}

}
