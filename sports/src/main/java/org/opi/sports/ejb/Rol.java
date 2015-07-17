package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Rol database table.
 * 
 */
@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRol;

	private String rol;

	//bi-directional many-to-one association to Permisos_Rol
	@OneToMany(mappedBy="rol")
	private List<Permisos_Rol> permisosRols;

	//bi-directional many-to-one association to Usuario_Rol
	@OneToMany(mappedBy="rol")
	private List<Usuario_Rol> usuarioRols;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Permisos_Rol> getPermisosRols() {
		return this.permisosRols;
	}

	public void setPermisosRols(List<Permisos_Rol> permisosRols) {
		this.permisosRols = permisosRols;
	}

	public Permisos_Rol addPermisosRol(Permisos_Rol permisosRol) {
		getPermisosRols().add(permisosRol);
		permisosRol.setRol(this);

		return permisosRol;
	}

	public Permisos_Rol removePermisosRol(Permisos_Rol permisosRol) {
		getPermisosRols().remove(permisosRol);
		permisosRol.setRol(null);

		return permisosRol;
	}

	public List<Usuario_Rol> getUsuarioRols() {
		return this.usuarioRols;
	}

	public void setUsuarioRols(List<Usuario_Rol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}

	public Usuario_Rol addUsuarioRol(Usuario_Rol usuarioRol) {
		getUsuarioRols().add(usuarioRol);
		usuarioRol.setRol(this);

		return usuarioRol;
	}

	public Usuario_Rol removeUsuarioRol(Usuario_Rol usuarioRol) {
		getUsuarioRols().remove(usuarioRol);
		usuarioRol.setRol(null);

		return usuarioRol;
	}

}