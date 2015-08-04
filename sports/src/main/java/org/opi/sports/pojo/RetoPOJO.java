package org.opi.sports.pojo;

import org.joda.time.DateTime;

/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase de los retos pojo utilizado para el registrar, modificar o eliminar
 *
 */
public class RetoPOJO {
	//id del reto
	private int idReto;
	//fecha del reto
	private DateTime fecha;
	//hora del reto
	private DateTime hora;
	//estado del reto
	private String estado;
	//mensaje del reto
	private String mensaje;
	// active del reto
	private byte active;
	
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
	/**
	 * Metodo get
	 */
	public DateTime getFecha() {
		return fecha;
	}
	/**
	 * Metodo set
	 */
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	/**
	 * Metodo get
	 */
	public DateTime getHora() {
		return hora;
	}
	/**
	 * Metodo set
	 */
	public void setHora(DateTime hora) {
		this.hora = hora;
	}
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
	public byte getActive() {
		return active;
	}
	/**
	 * Metodo set
	 */
	public void setActive(byte active) {
		this.active = active;
	}
}
