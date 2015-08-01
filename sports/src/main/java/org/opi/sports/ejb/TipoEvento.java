package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TipoEvento database table.
 * 
 */
@Entity
@NamedQuery(name="TipoEvento.findAll", query="SELECT t FROM TipoEvento t")
public class TipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoEvento;

	private byte active;

	private String tipo;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="tipoEvento")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Subscripcion
	@OneToMany(mappedBy="tipoEvento")
	private List<Subscripcion> subscripcions;

	public TipoEvento() {
	}

	public int getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setTipoEvento(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setTipoEvento(null);

		return evento;
	}

	public List<Subscripcion> getSubscripcions() {
		return this.subscripcions;
	}

	public void setSubscripcions(List<Subscripcion> subscripcions) {
		this.subscripcions = subscripcions;
	}

	public Subscripcion addSubscripcion(Subscripcion subscripcion) {
		getSubscripcions().add(subscripcion);
		subscripcion.setTipoEvento(this);

		return subscripcion;
	}

	public Subscripcion removeSubscripcion(Subscripcion subscripcion) {
		getSubscripcions().remove(subscripcion);
		subscripcion.setTipoEvento(null);

		return subscripcion;
	}

}