package org.opi.sports.contracts;

import org.opi.sports.pojo.UsuarioPOJO;
import java.util.*;

/**
* Fecha: 23-07-2015 version 1.0
*
* @author Juan Manuel Viales Chavarría
*
*Sprint #4 Se encarga de realizar los response de los usuarios, desde el front end.
*
*/
public class UsuarioResponse extends BaseResponse {
	
	private List<UsuarioPOJO> usuarios;

	public List<UsuarioPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPOJO> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "UsuarioResponse [usuarios=" + usuarios + "]";
	}
	
	
}
