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

	private byte active;

	private int cupo;

	private String direccion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	@Lob
	private String informacion;

	private String nombre;

	private String precio;
	
	private Integer diasParaRetiro;

	//bi-directional many-to-one association to Distribucion
	@OneToMany(mappedBy="evento")
	private List<Distribucion> distribucions;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="idDistrito")
	private Distrito distrito;

	//bi-directional many-to-one association to TipoEvento
	@ManyToOne
	@JoinColumn(name="idTipoEvento")
	private TipoEvento tipoEvento;

	//bi-directional many-to-one association to Tiquete
	@OneToMany(mappedBy="evento")
	private List<Tiquete> tiquetes;

	public Evento() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
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

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
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

	public Distrito getDistrito() {
		return this.distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	
	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
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

	public Integer getDiasParaRetiro() {
		return diasParaRetiro;
	}

	public void setDiasParaRetiro(Integer diasParaRetiro) {
		this.diasParaRetiro = diasParaRetiro;
	}

}