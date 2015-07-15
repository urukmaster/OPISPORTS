package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;

public class EstablecimientoDeportivoRequest extends BasePagingRequest {

	private int idEstablecimientoDeportivo;
	private String nombre;
	private String telefono;
	private String direccion;
	
	
	public int getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}


	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}


	public String toString() {
		EstablecimientoDeportivoPOJO establecimientoDeportivo = new EstablecimientoDeportivoPOJO();
		establecimientoDeportivo.setDireccion(direccion);
		establecimientoDeportivo.setIdEstablecimientoDeportivo(idEstablecimientoDeportivo);
		establecimientoDeportivo.setNombre(nombre);
		establecimientoDeportivo.setTelefono(telefono);
		
		return "EstablecimientoDeportivoRequest [EstablecimientoDeportivo="
				+ establecimientoDeportivo + "]";
	}

}
