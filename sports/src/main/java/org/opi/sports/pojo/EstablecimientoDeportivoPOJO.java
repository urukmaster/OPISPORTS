package org.opi.sports.pojo;

import java.util.List;

public class EstablecimientoDeportivoPOJO {
	
	private int idEstablecimientoDeportivo;
	private String nombre;
	private String telefono;
	private String direccion;
	
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
}
