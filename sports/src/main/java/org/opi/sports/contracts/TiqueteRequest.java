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

	private TiquetePOJO tiquete;

	public TiquetePOJO getEvento() {
		return tiquete;
	}

	public void setEvento(TiquetePOJO evento) {
		this.tiquete = evento;
	}

	public String toString(){
		return "TiqueteRequest [tiquete=" + tiquete  + "]";
	}
}
