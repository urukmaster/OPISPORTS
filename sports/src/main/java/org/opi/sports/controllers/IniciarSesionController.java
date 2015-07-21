package org.opi.sports.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.opi.sports.contracts.IniciarSesionRequest;
import org.opi.sports.contracts.IniciarSesionResponse;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.IniciarSesionHelper;
import org.opi.sports.pojo.RolPOJO;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.IniciarSesionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 18-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 02 Descripción: Controlador de iniciar sesión
 *
 */
@RestController
@RequestMapping(value = "rest/iniciarSesion")
public class IniciarSesionController {
	
	@Autowired
	IniciarSesionServiceInterface iniciarSesionService;
	
	@Autowired
	HttpServletRequest request;
	
	/**
	 * Metodo que valida el usuario por correo y contraseña
	 * 
	 */
	@RequestMapping(value = "validarUsuario", method = RequestMethod.GET)
	@Transactional
	public IniciarSesionResponse validarUsuario(@RequestBody IniciarSesionRequest iniciarSesionRequest){	

		Usuario usuarioLogeado = iniciarSesionService.ValidarUsuario(iniciarSesionRequest);
		
		IniciarSesionResponse iniciarSesionresponse = new IniciarSesionResponse();
		HttpSession sesionActual = request.getSession();
		
		if(usuarioLogeado == null){
			
			iniciarSesionresponse.setCode(401);
			iniciarSesionresponse.setErrorMessage("Usuario no autorizado");
			
		}else{
			//el codigo 200 significa que tuvo un acceso.correcto
			iniciarSesionresponse.setCode(200);
			iniciarSesionresponse.setCodeMessage("Usuario autorizado");
			
			//CREATE AND SET THE VALUES FOR THE CONTRACT OBJECT
			UsuarioPOJO usuario = new UsuarioPOJO();
			usuario = IniciarSesionHelper.getInstance().convertirUsuario(usuarioLogeado);	
			iniciarSesionresponse.setUsuario(usuario);
			sesionActual.setAttribute("idUsusario", usuarioLogeado.getIdUsuario());
		}	
		return iniciarSesionresponse;	
	}
}
