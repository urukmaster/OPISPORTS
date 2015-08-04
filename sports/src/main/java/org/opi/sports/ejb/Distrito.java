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

	//bi-directional many-to-one association to EstablecimientoDeportivo
	@OneToMany(mappedBy="distrito")
	private List<EstablecimientoDeportivo> establecimientoDeportivos;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="distrito")
	private List<Evento> eventos;

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

	public List<EstablecimientoDeportivo> getEstablecimientoDeportivos() {
		return this.establecimientoDeportivos;
	}

	public void setEstablecimientoDeportivos(List<EstablecimientoDeportivo> establecimientoDeportivos) {
		this.establecimientoDeportivos = establecimientoDeportivos;
	}

	public EstablecimientoDeportivo addEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		getEstablecimientoDeportivos().add(establecimientoDeportivo);
		establecimientoDeportivo.setDistrito(this);

		return establecimientoDeportivo;
	}

	public EstablecimientoDeportivo removeEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		getEstablecimientoDeportivos().remove(establecimientoDeportivo);
		establecimientoDeportivo.setDistrito(null);

		return establecimientoDeportivo;
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

}