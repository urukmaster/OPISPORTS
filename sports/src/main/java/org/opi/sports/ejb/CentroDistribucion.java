package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CentroDistribucion database table.
 * 
 */
@Entity
@NamedQuery(name="CentroDistribucion.findAll", query="SELECT c FROM CentroDistribucion c")
public class CentroDistribucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCentroDistribucion;

	private String correo;

	private String direccion;

	private String nombre;

	private String telefono;
	
	private byte active;

	//bi-directional many-to-one association to Distribucion
	@OneToMany(mappedBy="centroDistribucion")
	private List<Distribucion> distribucions;

	public CentroDistribucion() {
	}

	public int getIdCentroDistribucion() {
		return this.idCentroDistribucion;
	}

	public void setIdCentroDistribucion(int idCentroDistribucion) {
		this.idCentroDistribucion = idCentroDistribucion;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Distribucion> getDistribucions() {
		return this.distribucions;
	}

	public void setDistribucions(List<Distribucion> distribucions) {
		this.distribucions = distribucions;
	}

	public Distribucion addDistribucion(Distribucion distribucion) {
		getDistribucions().add(distribucion);
		distribucion.setCentroDistribucion(this);

		return distribucion;
	}

	public Distribucion removeDistribucion(Distribucion distribucion) {
		getDistribucions().remove(distribucion);
		distribucion.setCentroDistribucion(null);

		return distribucion;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

}