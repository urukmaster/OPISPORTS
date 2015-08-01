package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ActividadDeportiva database table.
 * 
 */
@Entity
@NamedQuery(name="ActividadDeportiva.findAll", query="SELECT a FROM ActividadDeportiva a")
public class ActividadDeportiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idActividadDeportiva;

	private byte active;

	private String actividadDeportiva;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="actividadDeportiva")
	private List<Servicio> servicios;

	public ActividadDeportiva() {
	}

	public int getIdActividadDeportiva() {
		return this.idActividadDeportiva;
	}

	public void setIdActividadDeportiva(int idActividadDeportiva) {
		this.idActividadDeportiva = idActividadDeportiva;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getActividadDeportiva() {
		return this.actividadDeportiva;
	}

	public void setActividadDeportiva(String actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setActividadDeportiva(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setActividadDeportiva(null);

		return servicio;
	}

}