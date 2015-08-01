package org.opi.sports.pojo;

import java.util.Date;

import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Inscripcion;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 03 Descripción: Esta clase es la representación de un objeto "Evento"
 *
 */
public class TiquetePOJO {

	private int idTiquete;
	private String estado;
	private Date fechaCaducidad;
	private double precio;
	private EventoPOJO idEvento;
	private Inscripcion idInscripcion;
	
	public int getIdTiquete() {
		return idTiquete;
	}
	public void setIdTiquete(int idTiquete) {
		this.idTiquete = idTiquete;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public EventoPOJO getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(EventoPOJO idEvento) {
		this.idEvento = idEvento;
	}
	public Inscripcion getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(Inscripcion idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

}
