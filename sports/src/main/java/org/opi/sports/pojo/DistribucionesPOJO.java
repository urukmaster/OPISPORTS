package org.opi.sports.pojo;

public class DistribucionesPOJO {
	private int idDistribucion;
	private int idCentro;
	private  byte active;
	private String nombreCentro;
	private String direccionCentro;
	private String telefonoCentro;
	private String correoCentro;
	public int getIdDistribucion() {
		return idDistribucion;
	}
	public void setIdDistribucion(int idDistribucion) {
		this.idDistribucion = idDistribucion;
	}
	public int getIdCentro() {
		return idCentro;
	}
	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public String getNombreCentro() {
		return nombreCentro;
	}
	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}
	public String getDireccionCentro() {
		return direccionCentro;
	}
	public void setDireccionCentro(String direccionCentro) {
		this.direccionCentro = direccionCentro;
	}
	public String getTelefonoCentro() {
		return telefonoCentro;
	}
	public void setTelefonoCentro(String telefonoCentro) {
		this.telefonoCentro = telefonoCentro;
	}
	public String getCorreoCentro() {
		return correoCentro;
	}
	public void setCorreoCentro(String correoCentro) {
		this.correoCentro = correoCentro;
	}
	
}
