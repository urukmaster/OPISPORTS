package org.opi.sports.repositories;

import org.opi.sports.ejb.Torneo;
import org.springframework.data.repository.CrudRepository;

public interface TorneoRepository extends CrudRepository<Torneo, Integer>{

	public <Torneos extends Torneo> Torneos save(Torneos torneos);
	public Torneo findOne(Integer idTorneo);
	
}
