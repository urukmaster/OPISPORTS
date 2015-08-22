package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 05 Descripción: Permite probar la funcionalidad al registrar
 *los usuario, desde el controller hasta el repositorio de
 *datos.
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class ActividadDeportivaTest {

	@Autowired
	private ActividadDeportivaServiceInterface actividadDeportivaService;
	
	/**
	 * Esta prueba permite saber si el servicio de la actividad deportiva se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getActividadDeportivaServiceTest(){
		assertNotNull(actividadDeportivaService);
	}
	
	/**
	* Esta prueba permite saber si la actividad deportiva se registra.
	*
	*/
	//@Test
	public void saveUsuarioTest(){
		ActividadDeportiva actividadDeportivaEJB = new ActividadDeportiva();
		actividadDeportivaEJB.setActividadDeportiva("Badminton");
		
		assertNotNull(actividadDeportivaService.save(actividadDeportivaEJB));
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de Actividades Deportivas
	 */
	@Test
	public void getListActividadDeportivaTest(){
		assertNotNull(actividadDeportivaService.getAllActividadDeportiva());
	}
}
