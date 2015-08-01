package org.opi.sports.pojo;

public class TiquetePOJO {
	
	private int idTIquete;
	
	private String fechaCaducidad;
	
	private String estado;
	
	private String precio;
	
	private EventoPOJO evento;
	


	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public EventoPOJO getEvento() {
		return evento;
	}

	public void setEvento(EventoPOJO evento) {
		this.evento = evento;
	}

	public int getIdTIquete() {
		return idTIquete;
	}

	public void setIdTIquete(int idTIquete) {
		this.idTIquete = idTIquete;
	}
}
