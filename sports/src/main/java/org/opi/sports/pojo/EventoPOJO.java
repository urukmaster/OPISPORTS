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
 *         Sprint 05 Descripción: Esta clase es la representación de un objeto
 *         "Evento"
 *
 */
public class EventoPOJO {

	private int idEvento;
	private byte active;
	private int cupo;
	private String direccion;
	private Date fecha;
	private Time hora;
	private String informacion;
	private String nombre;
	private String precio;
	private DistritoPOJO distrito;
	private EstablecimientoDeportivoPOJO establecimiento;
	private TipoEventoPOJO tipoEvento;
	private int diasParaRetiro;

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public DistritoPOJO getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoPOJO distrito) {
		this.distrito = distrito;
	}

	public EstablecimientoDeportivoPOJO getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(
			EstablecimientoDeportivoPOJO establecimiento) {
		this.establecimiento = establecimiento;
	}

	public TipoEventoPOJO getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEventoPOJO tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	public int getDiasParaRetiro() {
		return diasParaRetiro;
	}

	public void setDiasParaRetiro(int diasParaRetiro) {
		this.diasParaRetiro = diasParaRetiro;
	}

}
