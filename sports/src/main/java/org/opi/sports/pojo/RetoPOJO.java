package org.opi.sports.pojo;

import org.joda.time.DateTime;

public class RetoPOJO {
	private int idReto;
	private DateTime fecha;
	private DateTime hora;
	private String estado;
	private String mensaje;
	
	public int getIdReto() {
		return idReto;
	}
	public void setIdReto(int idReto) {
		this.idReto = idReto;
	}
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public DateTime getHora() {
		return hora;
	}
	public void setHora(DateTime hora) {
		this.hora = hora;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
