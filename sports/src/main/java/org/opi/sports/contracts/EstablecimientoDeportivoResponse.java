package org.opi.sports.contracts;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import java.util.List;

public class EstablecimientoDeportivoResponse extends BaseResponse {
	
	List<EstablecimientoDeportivoPOJO> establecimientoDeportivo;
	
	private int idEstablecimiento; 
	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	public int getIdEstablecimiento() {
		return idEstablecimiento;
	}

	public void setIdEstablecimiento(int idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<EstablecimientoDeportivoPOJO> getEstablecimientoDeportivo() {
		return establecimientoDeportivo;
	}

	public void setEstablecimientoDeportivo(
			List<EstablecimientoDeportivoPOJO> establecimientoDeportivo) {
		this.establecimientoDeportivo = establecimientoDeportivo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
