
package org.opi.sports.pojo;

import org.joda.time.DateTime;

public class RetosPOJO {
	
	private int idReto;
	private DateTime fecha;
	private DateTime hora;
	private String mensaje;
	private Integer idUsuario;
	private String nombreUsuario;
	private String telefonoUsuario;
	private String nombreServicio;
	private int precioServicio;
	private String nombreEstablecimiento;
	private String direccionEstablecimiento;
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public int getIdReto() {
		return idReto;
	}
	public void setIdReto(int idReto) {
		this.idReto = idReto;
	}
	public DateTime getFecha() {
		return fecha;
	}
	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
	public DateTime getHora() {
		return hora;
	}
	public void setHora(DateTime hora) {
		this.hora = hora;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public int getPrecioServicio() {
		return precioServicio;
	}
	public void setPrecioServicio(int precioServicio) {
		this.precioServicio = precioServicio;
	}
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}
	public String getDireccionEstablecimiento() {
		return direccionEstablecimiento;
	}
	public void setDireccionEstablecimiento(String direccionEstablecimiento) {
		this.direccionEstablecimiento = direccionEstablecimiento;
	}
}
