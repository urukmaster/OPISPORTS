package org.opi.sports.contracts;

/**
 * Fecha: 18-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Clase response del iniciar sesión
 */
public class IniciarSesionResponse extends BaseResponse{
	//Id del usuario
	private int idUsuario;
	//Nombre del usuario
	private String nombre;
	//Apellido del usuario
	private String apellido;
	
	/**
	 * Constructor de la clase
	 * 
	 */
	public IniciarSesionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo get
	 * 
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo set
	 * 
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	/**
	 * Metodo get
	 * 
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo set
	 * 
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
