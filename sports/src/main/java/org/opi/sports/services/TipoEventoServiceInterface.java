package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.TipoEvento;

/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 * 
 *Sprint #5 Descripción: Interface que brinda encapsular los metodos del servicio
 */
public interface TipoEventoServiceInterface {

	public List<TipoEvento> getAllTipoEvento();
	public <TiposEventos extends TipoEvento> TiposEventos save(TiposEventos tipoEvento);
	public boolean exists(Integer idTipoEvento);
}
