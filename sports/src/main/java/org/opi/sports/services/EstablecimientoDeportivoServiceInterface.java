package org.opi.sports.services;

import java.util.List;

import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.springframework.data.domain.Page;

public interface EstablecimientoDeportivoServiceInterface {

	public List<EstablecimientoDeportivo> getAllEstablecimientos();
}
