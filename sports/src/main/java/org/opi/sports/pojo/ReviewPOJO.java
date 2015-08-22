package org.opi.sports.pojo;

import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Usuario;

public class ReviewPOJO {
	
	private int idComentario;
	
	private String review;
	
	private EstablecimientoDeportivo idEstablecimientoDeportivo;
	
	private Usuario idUsuario;
	
	private byte active;
	
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
	public EstablecimientoDeportivo getIdEstablecimientoDeportivo() {
		return idEstablecimientoDeportivo;
	}
	public void setIdEstablecimientoDeportivo(EstablecimientoDeportivo idEstablecimientoDeportivo) {
		this.idEstablecimientoDeportivo = idEstablecimientoDeportivo;
	}
	public Usuario getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
}
