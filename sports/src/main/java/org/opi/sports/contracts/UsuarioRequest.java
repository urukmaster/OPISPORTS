package org.opi.sports.contracts;

import org.opi.sports.pojo.UsuarioPOJO;

/**
 * Fecha: 23-07-2015 version 1.0
 *
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #4 Se encarga de realizar los request de los usuarios, desde el fornt end.
 *
 */
public class UsuarioRequest extends BasePagingRequest {
	
	public UsuarioPOJO usuario;

	public UsuarioPOJO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString(){
		return "UsuarioRequest [usuario=" + usuario  + "]";
	}

}
