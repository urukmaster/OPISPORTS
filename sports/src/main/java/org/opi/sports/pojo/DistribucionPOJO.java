package org.opi.sports.pojo;

public class DistribucionPOJO {
	
	private int idDistribucion;
	
	private byte active;
	
	private CentroDistribucionPOJO idCentro;
	
	public int getIdDistribucion() {
		return idDistribucion;
	}

	public void setIdDistribucion(int idDistribucion) {
		this.idDistribucion = idDistribucion;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public CentroDistribucionPOJO getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(CentroDistribucionPOJO idCentro) {
		this.idCentro = idCentro;
	}

}
