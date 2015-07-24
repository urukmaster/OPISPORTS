package org.opi.sports.pojo;

import java.util.ArrayList;
import java.util.List;


/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase de los establecimientos deportivos POJO
 *
 */

import org.opi.sports.helpers.ReservacionesHelper;


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
	//Lista de servicios
	private List<ServicioPOJO> servicios;
	//Lista de calendarios
	private List<CalendarioPOJO> calendario;
	//Id del usuario que pertece el establecimiento
	private UsuarioPOJO idUsuario;
	/**
	 * Metodo get 
	 * 
	 */
	public int getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}
	/**
	 * Metodo get 
	 * 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo get 
	 * 
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo get 
	 * 
	 */
	public String getPaginaWeb() {
		return paginaWeb;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	/**
	 * Metodo get 
	 * 
	 */
	public UsuarioPOJO getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setIdUsuario(UsuarioPOJO idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * Metodo get 
	 * 
	 */
	public List<ServicioPOJO> getServicios() {
		return servicios;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setServicios(List<ServicioPOJO> servicios) {
		this.servicios = servicios;
	}
	/**
	 * Metodo get 
	 * 
	 */
	public List<CalendarioPOJO> getCalendario() {
		return calendario;
	}
	/**
	 * Metodo set 
	 * 
	 */
	public void setCalendario() {
		this.calendario = ReservacionesHelper.getInstance().calendarioSerializer(getServicios());
	}
}
