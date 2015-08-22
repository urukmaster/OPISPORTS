package org.opi.sports.contracts;

import java.sql.Time;

public class ServicioRequest extends BasePagingRequest {

	private int idServicio;

	private byte arbitro;

	private Time horaApertura;

	private Time horaCierre;
	
	private byte parqueo;

	private String precio;

	private String servicio;
	
	private Integer tipoServicio;
	
	private Integer establecimiento;
	
	private String accion;

	private Integer actividadDeportiva;
	
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

	public Integer getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(Integer tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public Integer getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Integer establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Integer getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(Integer actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}
	
}
