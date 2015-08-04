package org.opi.sports.contracts;



import java.util.Date;

import org.joda.time.DateTime;

import java.sql.Time;
/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase request de los retos
 *
 */
public class RetoRequest {
	//id del reto
	private int idReto;
	//estado del reto
	private String estado;
	//fecha del reto
	private Date fecha;
	//hora del reto
	private Time hora;
	//mensaje del reto
	private String mensaje;
	//active del reto
	private byte active;
	//servicios del eto
	private Integer servicio;
	//usuario del servicio
	private Integer usuario;
	
	/**
	 * Metodo get
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * Metodo set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Metodo get
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * Metodo set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * Metodo get
	 */
	public Time getHora() {
		return hora;
	}
	/**
	 * Metodo set
	 */
	public void setHora(Time hora) {
		this.hora = hora;
	}
	/**
	 * Metodo get
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * Metodo set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * Metodo get
	 */
	public Integer getServicio() {
		return servicio;
	}
	/**
	 * Metodo set
	 */
	public void setServicio(Integer servicio) {
		this.servicio = servicio;
	}
	/**
	 * Metodo get
	 */
	public Integer getUsuario() {
		return usuario;
	}
	/**
	 * Metodo set
	 */
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	/**
	 * Metodo get
	 */
	public byte getActive() {
		return active;
	}
	/**
	 * Metodo set
	 */
	public void setActive(byte active) {
		this.active = active;
	}
	/**
	 * Metodo get
	 */
	public int getIdReto() {
		return idReto;
	}
	/**
	 * Metodo set
	 */
	public void setIdReto(int idReto) {
		this.idReto = idReto;
	}
	
}
