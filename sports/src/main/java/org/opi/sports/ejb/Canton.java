package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Canton database table.
 * 
 */
@Entity
@NamedQuery(name="Canton.findAll", query="SELECT c FROM Canton c")
public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCanton;

	private String canton;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="canton")
	private List<Distrito> distritos;

	public Canton() {
	}

	public int getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(int idCanton) {
		this.idCanton = idCanton;
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Distrito> getDistritos() {
		return this.distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Distrito addDistrito(Distrito distrito) {
		getDistritos().add(distrito);
		distrito.setCanton(this);

		return distrito;
	}

	public Distrito removeDistrito(Distrito distrito) {
		getDistritos().remove(distrito);
		distrito.setCanton(null);

		return distrito;
	}

}