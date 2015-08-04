package org.opi.sports.contracts;

import java.sql.Time;
import java.util.Date;

import org.opi.sports.pojo.EventoPOJO;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 02 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

public class EventoRequest extends BasePagingRequest{

	private int idEvento;
	private byte active;
	private int cupo;
	private String direccion;
	private Date fecha;
	private Time hora;
	private String informacion;
	private String nombre;
	private String precio;
	private Integer distrito;
	private Integer establecimiento;
	private Integer tipoEvento;
	private String accion;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public byte isActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setEvento(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public Integer getDistrito() {
		return distrito;
	}
	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}
	public Integer getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(Integer establecimiento) {
		this.establecimiento = establecimiento;
	}
	public String getAccion() {
		return this.accion;
	}
	
	public void setAccion(String accion){
		this.accion = accion;
	}
	public Integer getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(Integer tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
}
