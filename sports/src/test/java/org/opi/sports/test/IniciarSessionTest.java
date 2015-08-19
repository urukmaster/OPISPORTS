package org.opi.sports.test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.IniciarSesionRequest;
import org.opi.sports.contracts.IniciarSesionResponse;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.IniciarSesionHelper;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.IniciarSesionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class IniciarSessionTest {

	@Autowired
	IniciarSesionServiceInterface iniciarSesionService;

	@Autowired
	HttpServletRequest request;

	/**
	 * Metodo que valida el usuario por correo y contraseña
	 * 
	 */
	@Test
	public void validarUsuario(
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
				request.getSession().setAttribute("idUsusario",
						usuarioLogeado.getIdUsuario());
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
		assertTrue(iniciarSesionresponse.getCode() == 200);
	}

}
