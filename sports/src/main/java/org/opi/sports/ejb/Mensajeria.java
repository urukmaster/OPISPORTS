package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Mensajeria database table.
 * 
 */
@Entity
@NamedQuery(name="Mensajeria.findAll", query="SELECT m FROM Mensajeria m")
public class Mensajeria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMensajeria;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horaEnvio;

	@Lob
	private String mensaje;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarioRemitente")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarioReceptor")
	private Usuario usuario2;

	public Mensajeria() {
	}

	public int getIdMensajeria() {
		return this.idMensajeria;
	}

	public void setIdMensajeria(int idMensajeria) {
		this.idMensajeria = idMensajeria;
	}

	public Date getHoraEnvio() {
		return this.horaEnvio;
	}

	public void setHoraEnvio(Date horaEnvio) {
		this.horaEnvio = horaEnvio;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}