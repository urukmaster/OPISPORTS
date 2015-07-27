package org.opi.sports.contracts;

import java.sql.Time;
import java.util.Date;


/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 01 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

public class ReservacionesRequest extends BasePagingRequest{
	
	private int idCalendario;
	private Date fecha;
	private Time hora;
	private String ocurrencia;
	private Integer servicio;
	private Integer usuario;
	private Integer establecimiento;
	
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

	public Integer getServicio() {
		return servicio;
	}

	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Integer establecimiento) {
		this.establecimiento = establecimiento;
	}
	
	
}
