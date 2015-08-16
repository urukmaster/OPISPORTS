package org.opi.sports.pojo;

import java.util.List;


public class InscripcionPOJO {
    
    private int idInscripcion;
    private UsuarioPOJO usuario;
    private List<TiquetePOJO> listaTiquetes;
    
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public UsuarioPOJO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioPOJO usuario) {
		this.usuario = usuario;
	}
	public List<TiquetePOJO> getlistaTiquetes() {
		return listaTiquetes;
	}
	public void setListaTiquetes(List<TiquetePOJO> listaTiquetes) {
		this.listaTiquetes = listaTiquetes;
	}
    
    
}
