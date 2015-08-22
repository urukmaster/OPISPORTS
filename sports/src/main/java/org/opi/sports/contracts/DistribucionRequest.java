package org.opi.sports.contracts;

public class DistribucionRequest {
	private int idDistribucion;
	private int idCentroDistribucion;
	private int idEvento;
	public int getIdDistribucion() {
		return idDistribucion;
	}
	public void setIdDistribucion(int idDistribucion) {
		this.idDistribucion = idDistribucion;
	}
	public int getIdCentroDistribucion() {
		return idCentroDistribucion;
	}
	public void setIdCentroDistribucion(int idCentroDistribucion) {
		this.idCentroDistribucion = idCentroDistribucion;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
}
