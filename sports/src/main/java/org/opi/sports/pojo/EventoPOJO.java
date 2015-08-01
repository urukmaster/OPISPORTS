package org.opi.sports.pojo;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.opi.sports.ejb.Tiquete;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 01 Descripción: Esta clase es la representación de un objeto "Evento"
 *
 */
public class EventoPOJO {

	private int idEvento;
	private boolean active;
	private int cupo;
	private String direccion;
	private Date fecha;
	private Time hora;
	private String informacion;
	private String nombre;
	private double precio;
	private DistritoPOJO idDistrito;
	private EstablecimientoDeportivoPOJO idEstablecimiento;
	private TipoEventoPOJO idTipoEvento;
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
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
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public DistritoPOJO getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(DistritoPOJO idDistrito) {
		this.idDistrito = idDistrito;
	}
	public EstablecimientoDeportivoPOJO getIdEstablecimiento() {
		return idEstablecimiento;
	}
	public void setIdEstablecimiento(EstablecimientoDeportivoPOJO idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}
	public TipoEventoPOJO getIdTipoEvento() {
		return idTipoEvento;
	}
	public void setIdTipoEvento(TipoEventoPOJO idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}
	
}
