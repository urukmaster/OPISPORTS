package org.opi.sports.pojo;

import java.util.List;

public class SubscripcionPOJO {
	
	private int idSubscripcion;
	
	private TipoEventoPOJO eventopojo;
	
	private byte active;

	public int getIdSubscripcion() {
		return idSubscripcion;
	}

	public void setIdSubscripcion(int idSubscripcion) {
		this.idSubscripcion = idSubscripcion;
	}

	public TipoEventoPOJO getEventopojo() {
		return eventopojo;
	}

	public void setEventopojo(TipoEventoPOJO eventopojo) {
		this.eventopojo = eventopojo;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}



}
