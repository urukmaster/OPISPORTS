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
