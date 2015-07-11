package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Establecimiento_Evento database table.
 * 
 */
@Entity
@NamedQuery(name="Establecimiento_Evento.findAll", query="SELECT e FROM Establecimiento_Evento e")
public class Establecimiento_Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEstablecimiento_idEvento;

	//bi-directional many-to-one association to EstablecimientoDeportivo
	@ManyToOne
	@JoinColumn(name="idEstablecimientoDeportivo")
	private EstablecimientoDeportivo establecimientoDeportivo;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="idEvento")
	private Evento evento;

	public Establecimiento_Evento() {
	}

	public int getIdEstablecimiento_idEvento() {
		return this.idEstablecimiento_idEvento;
	}

	public void setIdEstablecimiento_idEvento(int idEstablecimiento_idEvento) {
		this.idEstablecimiento_idEvento = idEstablecimiento_idEvento;
	}

	public EstablecimientoDeportivo getEstablecimientoDeportivo() {
		return this.establecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}