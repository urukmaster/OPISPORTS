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

	private String tipo;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="tipoEvento")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Supscripcion
	@OneToMany(mappedBy="tipoEvento")
	private List<Supscripcion> supscripcions;

	public TipoEvento() {
	}

	public int getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(int idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
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

	public List<Supscripcion> getSupscripcions() {
		return this.supscripcions;
	}

	public void setSupscripcions(List<Supscripcion> supscripcions) {
		this.supscripcions = supscripcions;
	}

	public Supscripcion addSupscripcion(Supscripcion supscripcion) {
		getSupscripcions().add(supscripcion);
		supscripcion.setTipoEvento(this);

		return supscripcion;
	}

	public Supscripcion removeSupscripcion(Supscripcion supscripcion) {
		getSupscripcions().remove(supscripcion);
		supscripcion.setTipoEvento(null);

		return supscripcion;
	}

}