package org.opi.sports.services;

import java.util.List;

import org.opi.sports.contracts.EventoRequest;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.ejb.Tiquete;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 *Sprint #3 Descripción: Interfaz para encapsular los metodos del servicio.
 */
public interface TipoServicioServiceInterface {

	public List<TipoServicio> getAllTipoServicio();
	public TipoServicio findOne(Integer idTipoServicio);
}
