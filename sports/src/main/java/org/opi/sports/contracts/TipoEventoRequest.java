package org.opi.sports.contracts;


/**
 * Fecha: 04-08-2015 version 1.0
 *
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #5 Se encarga de realizar los request de los tipos de eventos, desde el front end.
 *
 */
public class TipoEventoRequest extends BasePagingRequest{
	
	public int idTipoEvento;
	
	public String tipo;

	public int getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
