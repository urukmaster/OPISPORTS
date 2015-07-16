package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TiipoEvento database table.
 * 
 */
@Entity
@NamedQuery(name="TiipoEvento.findAll", query="SELECT t FROM TiipoEvento t")
public class TiipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTiipoEvento;

	private String tipo;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="tiipoEvento")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Supscripcion
	@OneToMany(mappedBy="tiipoEvento")
	private List<Supscripcion> supscripcions;

	public TiipoEvento() {
	}

	public int getIdTiipoEvento() {
		return this.idTiipoEvento;
	}

	public void setIdTiipoEvento(int idTiipoEvento) {
		this.idTiipoEvento = idTiipoEvento;
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
		evento.setTiipoEvento(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setTiipoEvento(null);

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
		supscripcion.setTiipoEvento(this);

		return supscripcion;
	}

	public Supscripcion removeSupscripcion(Supscripcion supscripcion) {
		getSupscripcions().remove(supscripcion);
		supscripcion.setTiipoEvento(null);

		return supscripcion;
	}

}