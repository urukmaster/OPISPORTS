package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Usuario_Rol database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario_Rol.findAll", query="SELECT u FROM Usuario_Rol u")
public class Usuario_Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuarioRol;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Usuario_Rol() {
	}

	public int getIdUsuarioRol() {
		return this.idUsuarioRol;
	}

	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}