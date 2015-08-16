package org.opi.sports.services;

import org.opi.sports.ejb.Torneo;

public interface TorneoServiceInterface {
	
	public <Torneos extends Torneo> Torneos save(Torneos torneos);
	public Torneo findOne(Integer idTorneo);
}
