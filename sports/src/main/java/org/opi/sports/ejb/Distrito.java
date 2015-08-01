package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Distrito database table.
 * 
 */
@Entity
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idDistrito;

	private String distrito;

	private String latitud;

	private String longitud;

	//bi-directional many-to-one association to Canton
	@ManyToOne
	@JoinColumn(name="idCanton")
	private Canton canton;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="distrito")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="distrito")
	private List<Servicio> servicios;

	public Distrito() {
	}

	public int getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public Canton getCanton() {
		return this.canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setDistrito(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setDistrito(null);

		return evento;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setDistrito(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setDistrito(null);

		return servicio;
	}

}