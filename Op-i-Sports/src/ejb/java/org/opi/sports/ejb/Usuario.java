package org.opi.sports.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String apellido;

	private String contrasenna;

	private String correo;

	private String nombre;

	private String nombreUsuario;

	private String telefono;

	//bi-directional many-to-one association to EstablecimientoDeportivo
	@OneToMany(mappedBy="usuario")
	private List<EstablecimientoDeportivo> establecimientoDeportivos;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(mappedBy="usuario")
	private List<Inscripcion> inscripcions;

	//bi-directional many-to-one association to Mensajeria
	@OneToMany(mappedBy="usuario1")
	private List<Mensajeria> mensajerias1;

	//bi-directional many-to-one association to Mensajeria
	@OneToMany(mappedBy="usuario2")
	private List<Mensajeria> mensajerias2;

	//bi-directional many-to-one association to Reservacione
	@OneToMany(mappedBy="usuario")
	private List<Reservaciones> reservaciones;

	//bi-directional many-to-one association to Reto
	@OneToMany(mappedBy="usuario")
	private List<Reto> retos;

	//bi-directional many-to-one association to Supscripcion
	@OneToMany(mappedBy="usuario")
	private List<Supscripcion> supscripcions;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="Usuario_Rol"
		, joinColumns={
			@JoinColumn(name="idUsuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idRol")
			}
		)
	private List<Rol> rols;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenna() {
		return this.contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<EstablecimientoDeportivo> getEstablecimientoDeportivos() {
		return this.establecimientoDeportivos;
	}

	public void setEstablecimientoDeportivos(List<EstablecimientoDeportivo> establecimientoDeportivos) {
		this.establecimientoDeportivos = establecimientoDeportivos;
	}

	public EstablecimientoDeportivo addEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		getEstablecimientoDeportivos().add(establecimientoDeportivo);
		establecimientoDeportivo.setUsuario(this);

		return establecimientoDeportivo;
	}

	public EstablecimientoDeportivo removeEstablecimientoDeportivo(EstablecimientoDeportivo establecimientoDeportivo) {
		getEstablecimientoDeportivos().remove(establecimientoDeportivo);
		establecimientoDeportivo.setUsuario(null);

		return establecimientoDeportivo;
	}

	public List<Inscripcion> getInscripcions() {
		return this.inscripcions;
	}

	public void setInscripcions(List<Inscripcion> inscripcions) {
		this.inscripcions = inscripcions;
	}

	public Inscripcion addInscripcion(Inscripcion inscripcion) {
		getInscripcions().add(inscripcion);
		inscripcion.setUsuario(this);

		return inscripcion;
	}

	public Inscripcion removeInscripcion(Inscripcion inscripcion) {
		getInscripcions().remove(inscripcion);
		inscripcion.setUsuario(null);

		return inscripcion;
	}

	public List<Mensajeria> getMensajerias1() {
		return this.mensajerias1;
	}

	public void setMensajerias1(List<Mensajeria> mensajerias1) {
		this.mensajerias1 = mensajerias1;
	}

	public Mensajeria addMensajerias1(Mensajeria mensajerias1) {
		getMensajerias1().add(mensajerias1);
		mensajerias1.setUsuario1(this);

		return mensajerias1;
	}

	public Mensajeria removeMensajerias1(Mensajeria mensajerias1) {
		getMensajerias1().remove(mensajerias1);
		mensajerias1.setUsuario1(null);

		return mensajerias1;
	}

	public List<Mensajeria> getMensajerias2() {
		return this.mensajerias2;
	}

	public void setMensajerias2(List<Mensajeria> mensajerias2) {
		this.mensajerias2 = mensajerias2;
	}

	public Mensajeria addMensajerias2(Mensajeria mensajerias2) {
		getMensajerias2().add(mensajerias2);
		mensajerias2.setUsuario2(this);

		return mensajerias2;
	}

	public Mensajeria removeMensajerias2(Mensajeria mensajerias2) {
		getMensajerias2().remove(mensajerias2);
		mensajerias2.setUsuario2(null);

		return mensajerias2;
	}

	public List<Reservaciones> getReservaciones() {
		return this.reservaciones;
	}

	public void setReservaciones(List<Reservaciones> reservaciones) {
		this.reservaciones = reservaciones;
	}

	public Reservaciones addReservacione(Reservaciones reservacione) {
		getReservaciones().add(reservacione);
		reservacione.setUsuario(this);

		return reservacione;
	}

	public Reservaciones removeReservacione(Reservaciones reservacione) {
		getReservaciones().remove(reservacione);
		reservacione.setUsuario(null);

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
		reto.setUsuario(this);

		return reto;
	}

	public Reto removeReto(Reto reto) {
		getRetos().remove(reto);
		reto.setUsuario(null);

		return reto;
	}

	public List<Supscripcion> getSupscripcions() {
		return this.supscripcions;
	}

	public void setSupscripcions(List<Supscripcion> supscripcions) {
		this.supscripcions = supscripcions;
	}

	public Supscripcion addSupscripcion(Supscripcion supscripcion) {
		getSupscripcions().add(supscripcion);
		supscripcion.setUsuario(this);

		return supscripcion;
	}

	public Supscripcion removeSupscripcion(Supscripcion supscripcion) {
		getSupscripcions().remove(supscripcion);
		supscripcion.setUsuario(null);

		return supscripcion;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}