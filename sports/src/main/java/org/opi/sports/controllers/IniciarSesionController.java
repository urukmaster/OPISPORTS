package org.opi.sports.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.activemq.filter.function.inListFunction;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
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
 *         Sprint 02 Descripción: Controlador de iniciar sesión
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
	@RequestMapping(value = "validarUsuario", method = RequestMethod.POST)
	public IniciarSesionResponse validarUsuario(
			@RequestBody IniciarSesionRequest iniciarSesionRequest) {

		Usuario usuarioLogeado = iniciarSesionService
				.ValidarUsuario(iniciarSesionRequest);
		IniciarSesionResponse iniciarSesionresponse = new IniciarSesionResponse();

		try {

			if (usuarioLogeado == null) {
				iniciarSesionresponse.setCode(401);
				iniciarSesionresponse.setErrorMessage("Usuario no autorizado");
			} else {
				// el codigo 200 significa que tuvo un acceso.correcto
				iniciarSesionresponse.setCode(200);
				iniciarSesionresponse.setCodeMessage("Usuario autorizado");

				// CREATE AND SET THE VALUES FOR THE CONTRACT OBJECT
				UsuarioPOJO usuario = new UsuarioPOJO();
				usuario = IniciarSesionHelper.getInstance().convertirUsuario(
						usuarioLogeado);
				iniciarSesionresponse.setUsuario(usuario);
				request.getSession().setAttribute("Usuario",
						usuario);
				iniciarSesionresponse.setCode(200);
				iniciarSesionresponse.setErrorMessage("Operación exitosa");
			}
		} catch (Exception exception) {
			iniciarSesionresponse.setCode(404);
			iniciarSesionresponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			iniciarSesionresponse.setErrorMessage(exception.getMessage());
		}
		return iniciarSesionresponse;

	}

	/**
	 * Metodo que invalida la sesion al cerrarla
	 * 
	 */
	@RequestMapping(value = "cerrarSesion", method = RequestMethod.GET)
	public void cerrarSesion() {
		request.getSession().invalidate();

	}

	@RequestMapping(value = "getSession", method = RequestMethod.GET)
	public IniciarSesionResponse getSession() {
		IniciarSesionResponse iniciarSesionResponse = new IniciarSesionResponse();
		Usuario usuarioLogeado;

		UsuarioPOJO usuario = new UsuarioPOJO();
		try {
			try {
				usuario = (UsuarioPOJO) request.getSession().getAttribute(
						"Usuario");
				if(usuario == null){
					iniciarSesionResponse.setCode(401);
					iniciarSesionResponse.setCodeMessage("Usuario no logeado");
				}
			} catch (NullPointerException nexception) {
				Exception exception = new Exception("401");
				throw exception;
			}

			iniciarSesionResponse.setCode(200);
			iniciarSesionResponse.setCodeMessage("Usuario logeado");
			iniciarSesionResponse.setUsuario(usuario);
		} catch (Exception exception) {
			if (exception.getMessage() == "401") {
				iniciarSesionResponse.setCode(401);
				iniciarSesionResponse.setCodeMessage("Usuario no logeado");
			} else {
				iniciarSesionResponse.setCode(404);
				iniciarSesionResponse
						.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
								+ "Lamentamos el incoveniente, favor intentar mas tarde");
				iniciarSesionResponse.setErrorMessage(exception.getMessage());
			}
		}

		return iniciarSesionResponse;

	}
}
