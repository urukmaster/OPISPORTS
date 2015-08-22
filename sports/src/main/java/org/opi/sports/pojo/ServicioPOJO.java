package org.opi.sports.pojo;

import java.sql.Time;
import java.util.List;

import org.joda.time.DateTime;

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
	private Time horaApertura;
	private Time horaCierre;
	private String precio;
	private String servicio;	
	private List<ReservacionesPOJO> reservacionesLista;	
	private TipoServicioPOJO tipoServicio;	
	private DateTime horaInicial;	
	private DateTime horaFinal;

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

	public Time getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(Time horaApertura) {
		this.horaApertura = horaApertura;
	}

	public Time getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(Time horaCierre) {
		this.horaCierre = horaCierre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public List<ReservacionesPOJO> getReservacionesLista() {
		return reservacionesLista;
	}

	public void setReservacionesLista(List<ReservacionesPOJO> reservacionesLista) {
		this.reservacionesLista = reservacionesLista;
	}

	public TipoServicioPOJO getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicioPOJO tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public DateTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(DateTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public DateTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(DateTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	

}
