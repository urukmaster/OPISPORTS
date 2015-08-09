package org.opi.sports.pojo;

public class ReviewsPOJO {
	
	private int idComentario;
	
	private int calificacion;
	
	private String review;
	
	private int idEstablecimientoDeportivo;
	
	private int idUsuario;
	
	private byte active;
	
	private String nombreUsuario;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}
	public void setIdEstablecimientoDeportivo(int idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
}
