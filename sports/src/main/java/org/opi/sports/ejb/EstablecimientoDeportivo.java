package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EstablecimientoDeportivo database table.
 * 
 */
@Entity
@NamedQuery(name="EstablecimientoDeportivo.findAll", query="SELECT e FROM EstablecimientoDeportivo e")
public class EstablecimientoDeportivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEstablecimientoDeportivo;

	private byte active;

	private String direccion;

	private String nombre;

	private String paginaWeb;

	private String telefono;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	private Distrito distrito;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;


	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="establecimientoDeportivo")
	private List<Foto> fotos;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="establecimientoDeportivo")
	private List<Review> reviews;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="establecimientoDeportivo")
	private List<Servicio> servicios;

	public EstablecimientoDeportivo() {
	}

	public int getIdEstablecimientoDeportivo() {
		return this.idEstablecimientoDeportivo;
	}

	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
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

	public String getPaginaWeb() {
		return this.paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setEstablecimientoDeportivo(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setEstablecimientoDeportivo(null);

		return foto;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setEstablecimientoDeportivo(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setEstablecimientoDeportivo(null);

		return review;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setEstablecimientoDeportivo(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setEstablecimientoDeportivo(null);

		return servicio;
	}

}