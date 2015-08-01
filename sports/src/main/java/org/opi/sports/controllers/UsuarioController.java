package org.opi.sports.controllers;

import javax.transaction.Transactional;

import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.contracts.UsuarioResponse;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.IniciarSesionHelper;
import org.opi.sports.helpers.UsuarioHelper;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 03 Descripción: Controlador rest del usuario
 *
 */
@RestController
@RequestMapping(value = "rest/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceInterface usuarioService;
	/**
	 * Metodo que obtiene la informacion para el perfil del usuario
	 * @return usuarioresponse
	 */
	@RequestMapping(value = "perfilUsuario", method =  RequestMethod.GET)
	@Transactional
	public UsuarioResponse perfilUsuario(/*@RequestBody UsuarioRequest usuarioRequest*/){
		 //int idUsuario = usuarioRequest.getIdUsuario();
		 Usuario usuario = usuarioService.findOne(2);
		 UsuarioResponse usuarioresponse = new UsuarioResponse();
		 if(usuarioService.exists(usuario.getIdUsuario())){
			 UsuarioPOJO usuariopojo = new UsuarioPOJO();
			 usuariopojo = UsuarioHelper.getInstance().perfilUsuario(usuario); 
			 usuarioresponse.setUsuario(usuariopojo); 
		 }
		 return usuarioresponse;
	}
}
