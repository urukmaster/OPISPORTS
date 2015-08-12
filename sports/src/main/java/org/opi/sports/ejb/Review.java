package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Review database table.
 * 
 */
@Entity
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idComentario;

	private String review;
	
	private byte active;

	//bi-directional many-to-one association to EstablecimientoDeportivo
	@ManyToOne
	@JoinColumn(name="idEstablecimiento")
	private EstablecimientoDeportivo establecimientoDeportivo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Review() {
	}

	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public EstablecimientoDeportivo getEstablecimientoDeportivo() {
		return this.establecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

}