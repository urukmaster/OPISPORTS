package org.opi.sports.pojo;

public class ReviewsPOJO {
	
	private int idComentario;

	private String review;
	
	private int idEstablecimientoDeportivo;
	
	private int idUsuario;
	
	private byte active;
	
	private String nombreUsuario;
	
	private String apellidoUsuario;
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
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
	public String getApellidoUsuario() {
		return apellidoUsuario;
	}
	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}
}
