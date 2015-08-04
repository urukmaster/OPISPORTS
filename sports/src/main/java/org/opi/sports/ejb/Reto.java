package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the Reto database table.
 * 
 */
@Entity
@NamedQuery(name="Reto.findAll", query="SELECT r FROM Reto r")
public class Reto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idReto;

	private byte active;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	@Lob
	private String mensaje;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	public Reto() {
	}

	public int getIdReto() {
		return this.idReto;
	}

	public void setIdReto(int idReto) {
		this.idReto = idReto;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}