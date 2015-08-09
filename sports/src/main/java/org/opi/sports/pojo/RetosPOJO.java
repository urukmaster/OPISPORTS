
package org.opi.sports.pojo;

import org.joda.time.DateTime;

/**
 * Fecha: 2-08-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 04 Descripción: Clase de los retos pojo utilizado para el listar
 *
 */
public class RetosPOJO {
	//id del reto
	private int idReto;
	//fecha del reto
	private DateTime fecha;
	//hora del reto
	private DateTime hora;
	//mensaje del reto
	private String mensaje;
	//id del usuario
	private Integer idUsuario;
	//nombre del usuario
	private String nombreUsuario;
	//apellido del usuario
	private String apellidoUsuario;
	//telefono del usuario
	private String telefonoUsuario;
	//id del servicio
	private int idServicio;
	//nombre del servicio
	private String nombreServicio;
	//precio del servicio
	private String precioServicio;
	//id del establecimiento
	private int idEstablecimiento;
	//nombre del establecimiento
	private String nombreEstablecimiento;
	//direccion del establecimiento
	private String direccionEstablecimiento;
	//active del eto
	private byte active;
	
	/**
	 * Metodo get
	 */
	public int getIdServicio() {
		return idServicio;
	}
	/**
	 * Metodo set
	 */
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	/**
	 * Metodo get
	 */
	public int getIdEstablecimiento() {
		return idEstablecimiento;
	}
	/**
	 * Metodo set
	 */
	public void setIdEstablecimiento(int idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}
	/**
	 * Metodo set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * Metodo get
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * Metodo set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * Metodo get
	 */
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	/**
	 * Metodo set
	 */
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	/**
	 * Metodo get
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}
	/**
	 * Metodo set
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	/**
	 * Metodo get
	 */
	public String getPrecioServicio() {
		return precioServicio;
	}
	/**
	 * Metodo set
	 */
	public void setPrecioServicio(String string) {
		this.precioServicio = string;
	}
	/**
	 * Metodo get
	 */
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}
	/**
	 * Metodo set
	 */
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}
	/**
	 * Metodo get
	 */
	public String getDireccionEstablecimiento() {
		return direccionEstablecimiento;
	}
	/**
	 * Metodo set
	 */
	public void setDireccionEstablecimiento(String direccionEstablecimiento) {
		this.direccionEstablecimiento = direccionEstablecimiento;
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
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
}
