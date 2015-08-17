package org.opi.sports.ejb;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Torneo database table.
 * 
 */
@Entity
@NamedQuery(name="Torneo.findAll", query="SELECT t FROM Torneo t")
public class Torneo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTorneo;

	private String torneo;
	
	private int cupos;
	
	private int horasTorneos;
	
	private int participantes;
	
	@OneToMany(mappedBy="torneo")
	private List<Reservaciones> reservaciones;
	
	public Torneo() {
	}

	public int getIdTorneo() {
		return this.idTorneo;
	}

	public void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}

	public List<Reservaciones> getReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(List<Reservaciones> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public int getHorasTorneos() {
		return horasTorneos;
	}

	public void setHorasTorneos(int horasTorneos) {
		this.horasTorneos = horasTorneos;
	}

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

}