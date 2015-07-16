package org.opi.sports.pojo;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.helpers.ReservacionesHelper;

public class EstablecimientoDeportivoPOJO {
	
	private int idEstablecimientoDeportivo;
	private String nombre;
	private String telefono;
	private String direccion;
	private List<ServicioPOJO> servicios;
	private List<CalendarioPOJO> calendario;

	
	public int getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}
	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<ServicioPOJO> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServicioPOJO> servicios) {
		this.servicios = servicios;
	}
	public List<CalendarioPOJO> getCalendario() {
		return calendario;
	}
	public void setCalendario() {
		this.calendario = ReservacionesHelper.getInstance().calendarioSerializer(getServicios());
	}
	
}
