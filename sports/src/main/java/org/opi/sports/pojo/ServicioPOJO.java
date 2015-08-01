package org.opi.sports.pojo;

import java.sql.Time;
import java.util.List;

import org.joda.time.DateTime;

public class ServicioPOJO {
	
	private int idServicio;

	private byte arbitro;

	private Time horaApertura;

	private Time horaCierre;
	
	private byte parqueo;

	private String precio;

	private String servicio;
	
	private List<ReservacionesPOJO> reservaciones;
	
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

	public byte getParqueo() {
		return parqueo;
	}

	public void setParqueo(byte parqueo) {
		this.parqueo = parqueo;
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
