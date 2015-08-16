package org.opi.sports.pojo;

import java.util.Date;

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
	private String precio;
	private String codigo;
	private EventoPOJO idEvento;
	private InscripcionPOJO idInscripcion;
	private String nombreEvento;
	
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
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public EventoPOJO getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(EventoPOJO idEvento) {
		this.idEvento = idEvento;
	}
	public InscripcionPOJO getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(InscripcionPOJO idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

}
