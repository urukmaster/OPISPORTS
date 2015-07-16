package org.opi.sports.pojo;

import java.util.List;

import org.opi.sports.ejb.Usuario_Rol;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase usuario POJO que posee toda la informacion del usuario
 *
 */
public class UsuarioPOJO {
	// Id del usuario
	private int idUsuario;
	//Nombre del usuario
	private String nombre;
	//Apellido del usuario
	private String apellido;
	//Contraseña del usuario
	private String contrasenna;
	//Correo del usuario
	private String correo;
	//Telefono del usuario
	private String telefono;
	//Lista de roles del usuario
	private List<Usuario_Rol> usuarioRols;
	
	/**
	 * Metodo get que devuelve el id del usuario 
	 * 
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo set que modifica el id del usuario 
	 * 
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * Metodo get que devuelve el nombre del usuario 
	 * 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo set que modifica el nombre del usuario 
	 * 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo get que devuelve el apellido del usuario 
	 * 
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo set que modifica el apellido del usuario 
	 * 
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Metodo get que devuelve la contraseña del usuario 
	 * 
	 */
	public String getContrasenna() {
		return contrasenna;
	}
	/**
	 * Metodo set que modifica la contraseña del usuario 
	 * 
	 */
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
	/**
	 * Metodo get que devuelve el correo del usuario 
	 * 
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Metodo set que modifica el correo del usuario 
	 *
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Metodo get que devuelve el telefono del usuario 
	 * 
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Metodo set que modifica el telefono del usuario 
	 *
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo get que devuelve los roles del usuario 
	 * 
	 */
	public List<Usuario_Rol> getUsuarioRols() {
		return usuarioRols;
	}
	/**
	 * Metodo set que modifica los roles del usuario 
	 *
	 */
	public void setUsuarioRols(List<Usuario_Rol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}
	
	

}
