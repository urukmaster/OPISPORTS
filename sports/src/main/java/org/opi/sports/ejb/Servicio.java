package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idServicio;

	private byte arbitro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horaApertura;

	private String horaCierre;

	private byte parqueo;

	private int precio;

	private String servicio;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="servicio")
	private List<Foto> fotos;

	//bi-directional many-to-one association to Reservacione
	@OneToMany(mappedBy="servicio")
	private List<Reservaciones> reservaciones;

	//bi-directional many-to-one association to Reto
	@OneToMany(mappedBy="servicio")
	private List<Reto> retos;

	//bi-directional many-to-one association to ActividadDeportiva
	@ManyToOne
	@JoinColumn(name="idActividadDeportiva")
	private ActividadDeportiva actividadDeportiva;

	//bi-directional many-to-one association to EstablecimientoDeportivo
	@ManyToOne
	@JoinColumn(name="idEstablecimiento")
	private EstablecimientoDeportivo establecimientoDeportivo;

	//bi-directional many-to-one association to TipoServicio
	@ManyToOne
	@JoinColumn(name="idTipoServicio")
	private TipoServicio tipoServicio;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public byte getArbitro() {
		return this.arbitro;
	}

	public void setArbitro(byte arbitro) {
		this.arbitro = arbitro;
	}

	public Date getHoraApertura() {
		return this.horaApertura;
	}

	public void setHoraApertura(Date horaApertura) {
		this.horaApertura = horaApertura;
	}

	public String getHoraCierre() {
		return this.horaCierre;
	}

	public void setHoraCierre(String horaCierre) {
		this.horaCierre = horaCierre;
	}

	public byte getParqueo() {
		return this.parqueo;
	}

	public void setParqueo(byte parqueo) {
		this.parqueo = parqueo;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Foto addFoto(Foto foto) {
		getFotos().add(foto);
		foto.setServicio(this);

		return foto;
	}

	public Foto removeFoto(Foto foto) {
		getFotos().remove(foto);
		foto.setServicio(null);

		return foto;
	}

	public List<Reservaciones> getReservaciones() {
		return this.reservaciones;
	}

	public void setReservaciones(List<Reservaciones> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public Reservaciones addReservacione(Reservaciones reservacione) {
		getReservaciones().add(reservacione);
		reservacione.setServicio(this);

		return reservacione;
	}

	public Reservaciones removeReservacione(Reservaciones reservacione) {
		getReservaciones().remove(reservacione);
		reservacione.setServicio(null);

		return reservacione;
	}

	public List<Reto> getRetos() {
		return this.retos;
	}

	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}

	public Reto addReto(Reto reto) {
		getRetos().add(reto);
		reto.setServicio(this);

		return reto;
	}

	public Reto removeReto(Reto reto) {
		getRetos().remove(reto);
		reto.setServicio(null);

		return reto;
	}

	public ActividadDeportiva getActividadDeportiva() {
		return this.actividadDeportiva;
	}

	public void setActividadDeportiva(ActividadDeportiva actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public EstablecimientoDeportivo getEstablecimientoDeportivo() {
		return this.establecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

	public TipoServicio getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

}