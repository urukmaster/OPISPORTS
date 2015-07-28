package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Tiquete database table.
 * 
 */
@Entity
@NamedQuery(name="Tiquete.findAll", query="SELECT t FROM Tiquete t")
public class Tiquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTiquete;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaCaducidad;

	private String precio;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="idEvento")
	private Evento evento;

	//bi-directional many-to-one association to Inscripcion
	@ManyToOne
	@JoinColumn(name="idInscripcion")
	private Inscripcion inscripcion;

	public Tiquete() {
	}

	public int getIdTiquete() {
		return this.idTiquete;
	}

	public void setIdTiquete(int idTiquete) {
		this.idTiquete = idTiquete;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Inscripcion getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

}