package org.opi.sports.contracts;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;

/**
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Clase request para la solicitud de información
 *
 */
public class EstablecimientoDeportivoRequest extends BasePagingRequest {
	
	//Id del establecimiento
	private int idEstablecimientoDeportivo;
	//Nombre del estableciminto
	private String nombre;
	//Telefono del establecimiento
	private String telefono;
	//Direccion del establecimiento
	private String direccion;
	//Pgina web del establecimiento
	private String paginaWeb;
	//Id del usuario relacionado al establecimiento
	private int idUsuario;
	//Tipo de transaccion en la base de datos
	private String accion;
	//Id del distrito relacionado al establecimiento
	private Integer idDistrito;
	/**
	 * Metodo get
	 */
	public int getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}
	/**
	 * Metodo set
	 */
	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}
	/**
	 * Metodo get
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo get
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * Metodo set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodo get
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodo set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodo get
	 */
	public String getPaginaWeb() {
		return paginaWeb;
	}
	/**
	 * Metodo set
	 */
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	/**
	 * Metodo get
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * Metodo set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Metodo get
	 */
	public String getAccion() {
		return accion;
	}
	/**
	 * Metodo set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	/**
	 * Metodo toString
	 */
	public String toString() {
		EstablecimientoDeportivoPOJO establecimientoDeportivo = new EstablecimientoDeportivoPOJO();
		establecimientoDeportivo.setIdEstablecimientoDeportivo(idEstablecimientoDeportivo);
		establecimientoDeportivo.setNombre(nombre);
		establecimientoDeportivo.setDireccion(direccion);
		establecimientoDeportivo.setTelefono(telefono);
		establecimientoDeportivo.setPaginaWeb(paginaWeb);
		return "EstablecimientoDeportivoRequest [EstablecimientoDeportivo="
				+ establecimientoDeportivo + "]";
	}


}
