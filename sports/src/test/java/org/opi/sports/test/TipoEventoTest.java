package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.services.TipoEventoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 04-08-2015 version 1.0
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *Sprint 01 Descripción: Permite probar la funcionalidad al registrar
 *los tipos de eventos, desde el controller hasta el repositorio de
 *datos.
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class TipoEventoTest {

	@Autowired
	private TipoEventoServiceInterface tipoEventoService;
	
	/**
	 * Esta prueba permite saber si el servicio de el tipo de evento se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getTipoEventoServiceTest(){
		assertNotNull(tipoEventoService);
	}
	
	
	/**
	* Esta prueba permite saber si el tipo de evento se registra.
	*
	*/
	//@Test
	public void saveTipoEventoTest(){
		TipoEvento tipoEventoEJB = new TipoEvento();
		tipoEventoEJB.setTipo("Ciclismo");
		tipoEventoEJB.setActive((byte)1);
		assertNotNull(tipoEventoService.save(tipoEventoEJB));
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de tipos de eventos
	 */
	@Test
	public void getListActividadDeportivaTest(){
		assertNotNull(tipoEventoService.getAllTipoEvento());
	}
}
