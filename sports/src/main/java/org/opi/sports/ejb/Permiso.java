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

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="Permisos_Rol"
		, joinColumns={
			@JoinColumn(name="idPermisos")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idRol")
			}
		)
	private List<Rol> rols;

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

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}