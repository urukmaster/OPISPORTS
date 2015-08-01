package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.ServicioPOJO;

public class ServicioResponse extends BaseResponse {

	private ServicioPOJO servicio;
	
	private List<ServicioPOJO> servicios;

	public ServicioPOJO getServicio() {
		return servicio;
	}

	public void setServicio(ServicioPOJO servicio) {
		this.servicio = servicio;
	}

	public List<ServicioPOJO> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioPOJO> servicios) {
		this.servicios = servicios;
	} 
	
}
