package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.TipoServicioResponse;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.pojo.TipoServicioPOJO;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Luis Esteban López Ramírez
 *
 *Sprint 01 Descripción: Permite probar la funcionalidad al consultar
 *los tipos de servicios, desde el controller hasta el repositorio de
 *datos. La funcionalidad de estar a prueba, segun distintos escenarios
 *
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class TipoServicioTest {

	@Autowired
	private TipoServicioServiceInterface tipoServicioService;
	
	
	/**
	 * Esta prueba permite saber si el servicio del Tipo Servicio se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getTipoServicioServiceTest(){
		assertNotNull(tipoServicioService);
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de Tipos de Servicios
	 */
	//@Test
	public void getLisTipoServicioTest(){
		assertNotNull(tipoServicioService.getAllTipoServicio());
	}
	
	/**
	 * Prueba la implementación del controller
	 */
	//@Test
	public void getTipoServicioControllerGetAll(){
		
		TipoServicioResponse tipoServicioResponse = new TipoServicioResponse();
		
		List<TipoServicio> tipoServicioList = tipoServicioService.getAllTipoServicio();
		List<TipoServicioPOJO> tipoServicioViewList = new ArrayList<TipoServicioPOJO>();
		
		for(TipoServicio tipoServicio : tipoServicioList){
			TipoServicioPOJO tipoServicioView = new TipoServicioPOJO();
			PojoUtils.pojoMappingUtility(tipoServicioView, tipoServicio);
			tipoServicioViewList.add(tipoServicioView);
		}
		
		tipoServicioResponse.setTipoServicio(tipoServicioViewList);
		
		assertNotNull(tipoServicioResponse);
	}
	
}
