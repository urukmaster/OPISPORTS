package org.opi.sports.pojo;

import java.util.Date;
import java.util.List;

import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.TipoServicio;

/**
 * Fecha: 20-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 * 
 * Sprint #4: Se encarga de especificar los servicios para los establecimientos deportivos
 *
 */
public class ServicioPOJO {
	private int idServicio;

	private byte arbitro;

	private Date horaApertura;

	private String horaCierre;
	
	private byte parqueo;

	private int precio;

	private String servicio;
	
	private List<ReservacionesPOJO> reservaciones;
	
	private TipoServicioPOJO tipoServicio;

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public byte getArbitro() {
		return arbitro;
	}

	public void setArbitro(byte arbitro) {
		this.arbitro = arbitro;
	}

	public Date getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(Date horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

	public byte getParqueo() {
		return parqueo;
	}

	public void setParqueo(byte parqueo) {
		this.parqueo = parqueo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public List<ReservacionesPOJO> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<ReservacionesPOJO> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public TipoServicioPOJO getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicioPOJO tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	

}
