package org.opi.sports.contracts;

import org.opi.sports.pojo.UsuarioPOJO;
/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 03 Descripción: Clase response del usuario
 *
 */
public class UsuarioResponse extends BaseResponse{
	// Objeto usuario
	private UsuarioPOJO usuario;
	/**
	 * Metodo get
	 */
	public UsuarioPOJO getUsuario() {
		return usuario;
	}
	/**
	 * Metodo set
	 */
	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}
}
