package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Permisos_Rol database table.
 * 
 */
@Entity
@NamedQuery(name="Permisos_Rol.findAll", query="SELECT p FROM Permisos_Rol p")
public class Permisos_Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRolPermiso;

	//bi-directional many-to-one association to Permiso
	@ManyToOne
	@JoinColumn(name="idPermisos")
	private Permiso permiso;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	public Permisos_Rol() {
	}

	public int getIdRolPermiso() {
		return this.idRolPermiso;
	}

	public void setIdRolPermiso(int idRolPermiso) {
		this.idRolPermiso = idRolPermiso;
	}

	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}