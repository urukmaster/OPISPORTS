package org.opi.sports.contracts;

/**
 * Fecha: 18-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Clase request del iniciar sesión
 */
public class IniciarSesionRequest {
	//Correo del usuario
	private String correo;
	//Contraseña del usuario
	private String contrasenna;
	
	/**
	 * Constructor de la clase
	 * 
	 */
	public IniciarSesionRequest() {
		super();
	}
	/**
	 * Constructor de la clase
	 * 
	 */
	public IniciarSesionRequest(String correo, String contrasenna) {
		super();
		this.correo = correo;
		this.contrasenna = contrasenna;
	}
	/**
	 * Metodo get
	 * 
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Metodo set
	 * 
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Metodo get
	 * 
	 */
	public String getContrasenna() {
		return contrasenna;
	}
	/**
	 * Metodo set
	 * 
	 */
	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}
}
