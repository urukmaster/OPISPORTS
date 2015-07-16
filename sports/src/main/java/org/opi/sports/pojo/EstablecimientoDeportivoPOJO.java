package org.opi.sports.pojo;

import java.util.List;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase de los establecimientos deportivos POJO
 *
 */
public class EstablecimientoDeportivoPOJO {
	
	//Id del estabecimiento deportivo
	private int idEstablecimientoDeportivo;
	//Nombre del establecimiento deportivo
	private String nombre;
	// Pagina web del establecimiento
	private String paginaWeb;
	//Telefono del establecimiento deportivo
	private String telefono;
	//Direccion del establecimeinto deportivo
	private String direccion;
	//Id del usuario que pertece el establecimiento
	private int idUsuario;
	/**
	 * Metodo get que devuelve el id del establecimiento deportivo 
	 * 
	 */
	public int getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}
	/**
	 * Metodo set que modifica el id del establecimiento deportivo 
	 * 
	 */
	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}
	/**
	 * Metodo get que devuelve el nombre del establecimiento deportivo 
	 * 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo set que modifica el nombre del establecimiento deportivo 
	 * 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}
	/**
	 * Metodo set que modifica el telefono del establecimiento deportivo 
	 * 
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo get que devuelve la direccion del establecimiento deportivo 
	 * 
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo set que modifica la direccion del establecimiento deportivo 
	 * 
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodo get que devuelve la pagina web del establecimiento deportivo 
	 * 
	 */
	public String getPaginaWeb() {
		return paginaWeb;
	}
	/**
	 * Metodo set que modifica la pagina web del establecimiento deportivo 
	 * 
	 */
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	/**
	 * Metodo get que devuelve el id  del usuario del establecimiento deportivo 
	 * 
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo set que modifica el id del usuario del establecimiento deportivo 
	 * 
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
