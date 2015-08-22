package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.helpers.ServicioHelper;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 26-07-2015
 * Version 1.0
 * 
 * @author Luis Esteban López Ramírez
 *
 *Srpint 04 Descripción: Pruebas para registrar y modificar servicios
 */
//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class ServicioTest {

	
	@Autowired
	private ServicioServiceInterface servicioService;
	
	@Autowired
	TipoServicioServiceInterface tipoServicioService;
	
	@Autowired
	ActividadDeportivaServiceInterface actividadDeportivaService;

		
	/**
	 * Esta prueba permite saber si se inyecta los servicios respectivos para
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getTipoServicioServiceTest(){
		assertNotNull(servicioService);
		assertNotNull(tipoServicioService);
	}
	
	//@Test
	public void registrarServicioTest(){
		
		ServicioRequest servicioRequest = new ServicioRequest();
		
		servicioRequest.setAccion("Registrar");
		servicioRequest.setArbitro((byte) 1);
		servicioRequest.setEstablecimiento(1);
		servicioRequest.setHoraApertura(new Time(new Date().getTime()));
		servicioRequest.setHoraCierre(new Time(new Date().getTime()));
		servicioRequest.setParqueo((byte) 1);
		servicioRequest.setPrecio("1000");
		servicioRequest.setServicio("Prueba");
		servicioRequest.setTipoServicio(1);
		
		TipoServicio tipoServicioEJB = tipoServicioService
				.findOne(servicioRequest.getTipoServicio());

		
		/**assertNotNull(ServicioHelper.getInstance().saveServicio(
				servicioRequest,  tipoServicioEJB,
				servicioService, actividadDeportivaService).getIdServicio());*/
		
	}
	
	//@Test
	public void modficarServicioTest(){
		
		ServicioRequest servicioRequest = new ServicioRequest();
		
		servicioRequest.setAccion("Registrar");
		servicioRequest.setArbitro((byte) 1);
		servicioRequest.setEstablecimiento(1);
		servicioRequest.setHoraApertura(new Time(new Date().getTime()));
		servicioRequest.setHoraCierre(new Time(new Date().getTime()));
		servicioRequest.setParqueo((byte) 1);
		servicioRequest.setPrecio("1000");
		servicioRequest.setServicio("Prueba");
		servicioRequest.setTipoServicio(1);
		servicioRequest.setIdServicio(1);
		
		TipoServicio tipoServicioEJB = tipoServicioService
				.findOne(servicioRequest.getTipoServicio());

		/**assertNotNull(ServicioHelper.getInstance().saveServicio(
				servicioRequest, tipoServicioEJB,
				servicioService,actividadDeportivaService).getIdServicio());*/
		
	}
}
