package org.opi.sports.contracts;
import java.util.Date;

/**
 * Fecha: 02-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 04 Descripción:Esta clase simula un httpservlet, 
 *simula las solicitudes del front end.
 */

import org.opi.sports.pojo.ProvinciaPOJO;

public class ProvinciaRequest extends BasePagingRequest{
	
	private int idProvincia;
	private String provincia;
	
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
