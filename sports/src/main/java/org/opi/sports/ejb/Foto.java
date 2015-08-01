package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Foto database table.
 * 
 */
@Entity
@NamedQuery(name="Foto.findAll", query="SELECT f FROM Foto f")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFoto;

	private String imagen;

	//bi-directional many-to-one association to EstablecimientoDeportivo
	@ManyToOne
	@JoinColumn(name="idEstablecimientoDeportivo")
	private EstablecimientoDeportivo establecimientoDeportivo;

	public Foto() {
	}

	public int getIdFoto() {
		return this.idFoto;
	}

	public void setIdFoto(int idFoto) {
		this.idFoto = idFoto;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public EstablecimientoDeportivo getEstablecimientoDeportivo() {
		return this.establecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

}