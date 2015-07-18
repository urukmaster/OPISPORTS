package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Permisos database table.
 * 
 */
@Entity
@Table(name="Permisos")
@NamedQuery(name="Permiso.findAll", query="SELECT p FROM Permiso p")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPermisos;

	private String permiso;

	//bi-directional many-to-one association to Permisos_Rol
	@OneToMany(mappedBy="permiso")
	private List<Permisos_Rol> permisosRols;

	public Permiso() {
	}

	public int getIdPermisos() {
		return this.idPermisos;
	}

	public void setIdPermisos(int idPermisos) {
		this.idPermisos = idPermisos;
	}

	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public List<Permisos_Rol> getPermisosRols() {
		return this.permisosRols;
	}

	public void setPermisosRols(List<Permisos_Rol> permisosRols) {
		this.permisosRols = permisosRols;
	}

	public Permisos_Rol addPermisosRol(Permisos_Rol permisosRol) {
		getPermisosRols().add(permisosRol);
		permisosRol.setPermiso(this);

		return permisosRol;
	}

	public Permisos_Rol removePermisosRol(Permisos_Rol permisosRol) {
		getPermisosRols().remove(permisosRol);
		permisosRol.setPermiso(null);

		return permisosRol;
	}

}