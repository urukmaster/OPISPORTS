package org.opi.sports.test;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.IniciarSesionRequest;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.services.IniciarSesionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 21-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernandez
 *
 *Sprint 02 Descripción: Permite probar la funcionalidad de validar el iniciar sesion 
 *desde el controller hasta el repositorio de
 *datos. La funcionalidad de estar a prueba, segun distintos escenarios
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class IniciarSesionTest {
	
	@Autowired
	private IniciarSesionServiceInterface iniciarSesionService;
	@Autowired
	HttpServletRequest ht;
	/**
	 * Esta prueba permite saber si el usuario se encuentra registrado por medio 
	 * de el correo y la contraseña, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	
	
	@Test
	public void getActividadDeportivaServiceTest(){
		assertNotNull(iniciarSesionService);
	}
	
	//@Test
	public void  iniciarSesion(){
		HttpSession sesionActual = ht.getSession();
		//------------------------------------------------------------------
		IniciarSesionRequest request = new IniciarSesionRequest();
		request.setCorreo("jvialesc@ucenfotec.ac.cr");
		request.setContrasenna("Abcd12345/");
		Usuario usuario = iniciarSesionService.ValidarUsuario(request);
		//-------------------------------------------------------------------
		sesionActual.setAttribute("idUsusario", usuario.getIdUsuario());
		assertNotNull(usuario);
	}
	/**
	 * Esta prueba permite saber si el usuario se encuentra null o la variable de sesion se encuentra vacia
	 */
	//@Test
	public void cerrarSesion(){
		

	}	
}
