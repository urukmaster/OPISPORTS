package org.opi.sports.test;

import static org.junit.Assert.*;

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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class IniciarSesionTest {
	
	@Autowired
	private IniciarSesionServiceInterface iniciarSesionService;
	
	@Test
	public void  iniciarSesion(){
		IniciarSesionRequest request = new IniciarSesionRequest();
		request.setCorreo("maraica");
		request.setContrasenna("12345678");
		
		Usuario usuario = iniciarSesionService.ValidarUsuario(request);
		System.out.println(usuario.getIdUsuario());
		assertNotNull(usuario);
	}
}
