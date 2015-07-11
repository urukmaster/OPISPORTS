package org.opi.sports.pojo;

import java.sql.Time;
import java.util.Date;

public class ReservacionesPOJO {

	private int idCalendario;
	private Date fecha;
	private Time hora;
	private String ocurrencia;
	private int idServicio;
	private int idUsuario;
	
	public int getIdCalendario() {
		return idCalendario;
	}
	
	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Time getHora() {
		return hora;
	}
	
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public String getOcurrencia() {
		return ocurrencia;
	}
	
	public void setOcurrencia(String ocurrencia) {
		this.ocurrencia = ocurrencia;
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
