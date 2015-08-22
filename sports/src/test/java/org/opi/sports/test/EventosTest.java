package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.EventoRequest;
import org.opi.sports.contracts.EventoResponse;
import org.opi.sports.ejb.Evento;
import org.opi.sports.helpers.EventosHelper;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Fecha: 22-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 05 Descripción: Permite probar la funcionalidad al consultar
 *los eventos, desde el controller hasta el repositorio de
 *datos. La funcionalidad debe estar a prueba, segun distintos escenarios
 *
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuración del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class EventosTest {

	@Autowired
	private EventoServiceInterface eventoService;

		
	/**
	 * Esta prueba permite saber si el servicio de Eventos se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getEventoServiceTest(){
		assertNotNull(eventoService);
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de Tipos de Servicios
	 */
	@Test
	public void getLisEventoTest(){
		assertNotNull(eventoService.getAllEventos());
	}
	
	/**
	 * Prueba la implementación del controller
	 */
	@Test
	public void getEventoControllerGetAll(){
		
		EventoResponse eventoResponse = new EventoResponse();
		
		List<Evento> eventoList = eventoService.getAllEventos();
		List<EventoPOJO> eventoViewList = new ArrayList<EventoPOJO>();
		
		for(Evento eventos : eventoList){
			EventoPOJO eventosView = new EventoPOJO();
			PojoUtils.pojoMappingUtility(eventosView, eventos);
			eventoViewList.add(eventosView);
		}
		
		eventoResponse.setEventos(eventoViewList);
		
		assertNotNull(eventoResponse);
	}
	/**
	 * Prueba para guardar o modificar eventos
	 */
	//@Test
	public void saveEventos(){
		EventoResponse eventoResponse = new EventoResponse();
		EventoRequest eventoRequest = new EventoRequest();
		eventoRequest.setAccion("Registrar");
		eventoRequest.setCupo(1000);
		eventoRequest.setDireccion("Prueba");
		eventoRequest.setEvento("Evento Prueba");
		eventoRequest.setFecha(new Date());
		eventoRequest.setHora(new Time(new Date().getTime()));
		eventoRequest.setInformacion("Prueba");
		eventoRequest.setPrecio("10000");
		eventoRequest.setTipoEvento(1);
		
		EventoPOJO evento = EventosHelper.getInstance().save(eventoRequest, eventoService);
		
		eventoResponse.setEvento(evento);
	}
	
}
