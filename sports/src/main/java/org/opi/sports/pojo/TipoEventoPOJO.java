package org.opi.sports.pojo;

import java.util.List;

/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 05 Descripción: Clase tipo de evento POJO
 *
 */
public class TipoEventoPOJO {
	private int idTipoEvento;
	private byte active;
	private String tipo;
	
	public int getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipoEvento) {
		this.tipo = tipoEvento;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
}
