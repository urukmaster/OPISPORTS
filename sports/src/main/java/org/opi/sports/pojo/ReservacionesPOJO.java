package org.opi.sports.pojo;

import java.util.Date;

import org.joda.time.DateTime;

public class ReservacionesPOJO {

	private int idCalendario;

	private Date fecha;

	private DateTime hora;

	private String ocurrencia;

	private Integer idServicio;

	private Integer idUsuario;

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

	public DateTime getHora() {
		return hora;
	}

	public void setHora(DateTime hora) {
		this.hora = hora;
	}

	public String getOcurrencia() {
		return ocurrencia;
	}

	public void setOcurrencia(String ocurrencia) {
		this.ocurrencia = ocurrencia;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	
}
