package org.opi.sports.pojo;

import java.util.List;

/**
 * Fecha: 21-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Clase Rol POJO 
 *
 */
public class RolPOJO {
	//Id del rol
	private int idRol;
	//Nombre del rol
	private String rol;
	//Lista de permisos POJO
	private List<PermisoPOJO> permisos;
	/**
	 * Metodo get
	 */
	public int getIdRol() {
		return idRol;
	}
	/**
	 * Metodo set
	 */
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	/**
	 * Metodo get
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * Metodo set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	/**
	 * Metodo get
	 */
	public List<PermisoPOJO> getPermisos() {
		return permisos;
	}
	/**
	 * Metodo set
	 */
	public void setPermisos(List<PermisoPOJO> permisos) {
		this.permisos = permisos;
	}
}
