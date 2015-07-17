package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;


/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase request para la solicitud de infromación
 *
 */
public class EstablecimientoDeportivoRequest extends BasePagingRequest {

	private int idEstablecimientoDeportivo;
	private String nombre;
	private String telefono;
	private String direccion;
	private EstablecimientoDeportivoPOJO establecimiento;
	
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


	public EstablecimientoDeportivoPOJO getEstablecimiento() {
		return establecimiento;
	}


	public void setEstablecimiento(EstablecimientoDeportivoPOJO establecimiento) {
		this.establecimiento = establecimiento;
	}

}
