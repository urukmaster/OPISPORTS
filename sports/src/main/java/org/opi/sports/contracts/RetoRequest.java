package org.opi.sports.contracts;

import org.joda.time.DateTime;

public class RetoRequest {
	
	private String estado;
	private DateTime fecha;
	private DateTime hora;
	private String mensaje;
	private int idServicio;
	private int idUsuario;
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
