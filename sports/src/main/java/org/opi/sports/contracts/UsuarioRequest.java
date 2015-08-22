package org.opi.sports.contracts;

/**
 * Fecha: 09-08-2015 version 2.0
 *
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint #6 Se encarga de realizar los request de los usuarios, desde el fornt end.
 *
 */
public class UsuarioRequest extends BasePagingRequest {
	
	private int idUsuario;
	
	public String nombre;
	
	public String apellido;
	
	public String telefono;
	
	public String correo;
	
	public String contrasenna;
	
	public byte active;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}
	
	
	
}
