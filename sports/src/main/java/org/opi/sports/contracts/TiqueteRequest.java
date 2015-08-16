package org.opi.sports.contracts;

import java.util.Date;

/**
 * Fecha: 25-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 03 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

public class TiqueteRequest extends BasePagingRequest{

	private Integer idTiquete;
	private byte active;
	private String estado;
	private Date fechaCaducidad;
	private String precio;
	private Integer evento;
	private Integer inscripcion;
	private Integer usuario;
	private String accion;
	private String codigo;
	private Integer cantidad;
	private String nombreEvento;
	
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public Integer getIdTiquete() {
		return idTiquete;
	}
	public void setIdTiquete(Integer idTiquete) {
		this.idTiquete = idTiquete;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
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
	public Integer getEvento() {
		return evento;
	}
	public void setEvento(Integer evento) {
		this.evento = evento;
	}
	public Integer getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(Integer inscripcion) {
		this.inscripcion = inscripcion;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}	
	public String getAccion() {
		return accion;
	}	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	
}
