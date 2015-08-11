package org.opi.sports.ejb;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TipoReservacion database table.
 * 
 */
@Entity
@NamedQuery(name="TipoReservacion.findAll", query="SELECT t FROM TipoReservacion t")
public class TipoReservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoReservacion;

	private byte active;

	private String tipoReservacion;
	
	@OneToMany(mappedBy="tipoReservacion")
	private List<Reservaciones> reservaciones;
	
	public TipoReservacion() {
	}

	public int getIdTipoReservacion() {
		return this.idTipoReservacion;
	}

	public void setIdTipoReservacion(int idTipoReservacion) {
		this.idTipoReservacion = idTipoReservacion;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getTipoReservacion() {
		return this.tipoReservacion;
	}

	public void setTipo(String tipoReservacion) {
		this.tipoReservacion = tipoReservacion;
	}

	public List<Reservaciones> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservaciones> reservaciones) {
		this.reservaciones = reservaciones;
	}

}