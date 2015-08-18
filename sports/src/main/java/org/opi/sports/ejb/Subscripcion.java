package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Subscripcion database table.
 * 
 */
@Entity
@NamedQuery(name="Subscripcion.findAll", query="SELECT s FROM Subscripcion s")
public class Subscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSubscripcion;
	
	private byte active;
	
	//bi-directional many-to-one association to TipoEvento
	@ManyToOne
	@JoinColumn(name="idTipoEvento")
	private TipoEvento tipoEvento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Subscripcion() {
	}

	public int getIdSubscripcion() {
		return this.idSubscripcion;
	}

	public void setIdSubscripcion(int idSubscripcion) {
		this.idSubscripcion = idSubscripcion;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
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