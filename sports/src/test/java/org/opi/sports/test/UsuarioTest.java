package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.IniciarSesionRequest;
import org.opi.sports.contracts.UsuarioResponse;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.ejb.Permiso;
import org.opi.sports.ejb.Permisos_Rol;
import org.opi.sports.ejb.Rol;
import org.opi.sports.ejb.Usuario_Rol;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 03 Descripción: Permite probar la funcionalidad al registrar
 *los usuario, desde el controller hasta el repositorio de
 *datos.
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class UsuarioTest {
	
	@Autowired
	private UsuarioServiceInterface usuarioService;
	
	/**
	 * Esta prueba permite saber si el servicio del Usuario se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getUsuarioServiceTest(){
		assertNotNull(usuarioService);
	}

	/**
	* Esta prueba permite saber si el usuario se registra.
	*
	*/
	//@Test
	public void saveUsuarioTest(){
		Usuario usuarioEJB = new Usuario();
		usuarioEJB.setCorreo("jvialesc@gmail.com");
		usuarioEJB.setNombre("Juan Manuel");
		usuarioEJB.setApellido("Viales");
		usuarioEJB.setTelefono("84427024");
		usuarioEJB.setContrasenna("147852369");
		assertNotNull(usuarioService.save(usuarioEJB));
	}
	
	/**
	* Esta prueba permite saber si el usuario se registra con su rol.
	*
	*/
	
	//@Test
	public void saveRolTest(){
		
		//------------------------------------------------------------------
		UsuarioRequest request = new UsuarioRequest();
		request.setCorreo("jvialesc@ucenfotec.ac.cr");
		request.setContrasenna("147852369");
		Usuario usuario = usuarioService.ValidarUsuario(request);	
			
		Rol rolEJB = new Rol();
		rolEJB.setIdRol(1);
		
		Usuario_Rol roles = new Usuario_Rol();
		roles.setRol(rolEJB);
		roles.setUsuario(usuario);
		
		assertNotNull(usuarioService.save(roles));
	}
	
	/**
	* Esta prueba permite saber si el usuario se actualizo.
	*
	*/
	//@Test
	public void updateUsuarioTest(){
		Usuario usuarioEJB = new Usuario();
		usuarioEJB.setIdUsuario(2);
		usuarioEJB.setCorreo("juanmanu24@gmail.com");
		usuarioEJB.setNombre("Juan Manuel");
		usuarioEJB.setApellido("Viales");
		usuarioEJB.setTelefono("84427024");
		usuarioEJB.setContrasenna("147852369");
		assertNotNull(usuarioService.save(usuarioEJB));
	}
}
