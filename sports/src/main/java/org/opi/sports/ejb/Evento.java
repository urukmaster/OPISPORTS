package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEvento;

	private int cupo;

	private String direccion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	@Lob
	private String informacion;

	private String nombre;

	//bi-directional many-to-one association to Distribucion
	@OneToMany(mappedBy="evento")
	private List<Distribucion> distribucions;

	//bi-directional many-to-one association to Establecimiento_Evento
	@OneToMany(mappedBy="evento")
	private List<Establecimiento_Evento> establecimientoEventos;

	//bi-directional many-to-one association to Tiquete
	@OneToMany(mappedBy="evento")
	private List<Tiquete> tiquetes;

	//bi-directional many-to-one association to TipoEvento
	@ManyToOne
	@JoinColumn(name="idTipoEvento")
	private TipoEvento tipoEvento;

	public Evento() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getCupo() {
		return this.cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getInformacion() {
		return this.informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Distribucion> getDistribucions() {
		return this.distribucions;
	}

	public void setDistribucions(List<Distribucion> distribucions) {
		this.distribucions = distribucions;
	}

	public Distribucion addDistribucion(Distribucion distribucion) {
		getDistribucions().add(distribucion);
		distribucion.setEvento(this);

		return distribucion;
	}

	public Distribucion removeDistribucion(Distribucion distribucion) {
		getDistribucions().remove(distribucion);
		distribucion.setEvento(null);

		return distribucion;
	}

	public List<Establecimiento_Evento> getEstablecimientoEventos() {
		return this.establecimientoEventos;
	}

	public void setEstablecimientoEventos(List<Establecimiento_Evento> establecimientoEventos) {
		this.establecimientoEventos = establecimientoEventos;
	}

	public Establecimiento_Evento addEstablecimientoEvento(Establecimiento_Evento establecimientoEvento) {
		getEstablecimientoEventos().add(establecimientoEvento);
		establecimientoEvento.setEvento(this);

		return establecimientoEvento;
	}

	public Establecimiento_Evento removeEstablecimientoEvento(Establecimiento_Evento establecimientoEvento) {
		getEstablecimientoEventos().remove(establecimientoEvento);
		establecimientoEvento.setEvento(null);

		return establecimientoEvento;
	}

	public List<Tiquete> getTiquetes() {
		return this.tiquetes;
	}

	public void setTiquetes(List<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}

	public Tiquete addTiquete(Tiquete tiquete) {
		getTiquetes().add(tiquete);
		tiquete.setEvento(this);

		return tiquete;
	}

	public Tiquete removeTiquete(Tiquete tiquete) {
		getTiquetes().remove(tiquete);
		tiquete.setEvento(null);

		return tiquete;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}