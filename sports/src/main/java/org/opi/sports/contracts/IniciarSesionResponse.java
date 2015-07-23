package org.opi.sports.contracts;
import java.util.List;

import org.opi.sports.ejb.Permisos_Rol;
import org.opi.sports.ejb.Rol;
import org.opi.sports.ejb.Permiso;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Usuario_Rol;
import org.opi.sports.pojo.UsuarioPOJO;
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
	//Lista de roles
	private List<Usuario_Rol> roles;
	//Usuario POJO 
	private UsuarioPOJO usuario; 


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
	public List<Usuario_Rol> getRoles() {
		return roles;
	}
	/**
	 * Metodo set
	 * 
	 */
	public void setRoles(List<Usuario_Rol> roles) {
		this.roles = roles;
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
	/**
	 * Metodo get
	 * 
	 */
	public UsuarioPOJO getUsuario() {
		return usuario;
	}
	/**
	 * Metodo set
	 * 
	 */
	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}

	
}
