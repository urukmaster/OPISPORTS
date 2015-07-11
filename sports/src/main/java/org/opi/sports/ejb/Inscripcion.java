package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Inscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Inscripcion.findAll", query="SELECT i FROM Inscripcion i")
public class Inscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idInscripcion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Tiquete
	@OneToMany(mappedBy="inscripcion")
	private List<Tiquete> tiquetes;

	public Inscripcion() {
	}

	public int getIdInscripcion() {
		return this.idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Tiquete> getTiquetes() {
		return this.tiquetes;
	}

	public void setTiquetes(List<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public Tiquete addTiquete(Tiquete tiquete) {
		getTiquetes().add(tiquete);
		tiquete.setInscripcion(this);

		return tiquete;
	}

	public Tiquete removeTiquete(Tiquete tiquete) {
		getTiquetes().remove(tiquete);
		tiquete.setInscripcion(null);

		return tiquete;
	}

}