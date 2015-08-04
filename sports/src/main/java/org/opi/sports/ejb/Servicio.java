package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
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
	
	private byte active;

	private Time horaApertura;

	private Time horaCierre;

	private String precio;

	private String servicio;

	//bi-directional many-to-one association to Reservaciones
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

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	public Time getHoraApertura() {
		return this.horaApertura;
	}

	public void setHoraApertura(Time horaApertura) {
		this.horaApertura = horaApertura;
	}

	public Time getHoraCierre() {
		return this.horaCierre;
	}

	public void setHoraCierre(Time horaCierre) {
		this.horaCierre = horaCierre;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
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