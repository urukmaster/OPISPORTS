package org.opi.sports.contracts;

import org.opi.sports.pojo.TiquetePOJO;


/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 03 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

public class TiqueteRequest extends BasePagingRequest{

	private TiquetePOJO evento;

	public TiquetePOJO getEvento() {
		return evento;
	}

	public void setEvento(TiquetePOJO evento) {
		this.evento = evento;
	}

	public String toString(){
		return "TiqueteRequest [evento=" + evento  + "]";
	}
}
