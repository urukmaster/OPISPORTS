package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.contracts.ReservacionesResponse;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.contracts.RetoResponse;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.helpers.RetoHelper;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.services.RetoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 01-08-2015 version 1.0
 * 
 * @author Mauricio Araica
 *
 *Sprint 04 Descripción: prueba de retos
 *
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuración del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class RetoTest {

	@Autowired
	private RetoServiceInterface retoService;
	
	@Autowired
	UsuarioServiceInterface usuarioServices;

	@Autowired
	ServicioServiceInterface servicioServices;
	
	/**
	 * Esta prueba permite saber si el reto se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getRetoServiceTest(){
		assertNotNull(retoService);
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de retos
	 */
	@Test
	public void getLisTRetosTest(){
		assertNotNull(retoService.getAllRetos());
	}
	
	/**
	 * Prueba la implementación del controller
	 */
	@Test
	public void getRetosControllerGetAll(){
		
		RetoResponse retoResponse = new RetoResponse();
		
		List<Reto> retoList = retoService.getAllRetos();
		List<RetosPOJO> retosViewList = new ArrayList<RetosPOJO>();
		
		for(Reto retos : retoList){
			RetosPOJO retosView = new RetosPOJO();
			PojoUtils.pojoMappingUtility(retosView, retos);
			retosViewList.add(retosView);
		}
		
		retoResponse.setRetospojo(retosViewList);
		
		assertNotNull(retoResponse);
	}
	
	//@Test
	public void saveReto(){
		
		RetoRequest reto = new RetoRequest();
		reto.setFecha(new Date());
		reto.setHora(new Time(new Date().getTime()));
		reto.setEstado("En espera");
		reto.setMensaje("Prueba");
		reto.setUsuario(1);
		reto.setServicio(1);
		
		RetoPOJO retoView = RetoHelper.getInstance().saveReto(reto, retoService,
				usuarioServices.findOne(reto.getUsuario()), servicioServices.findOne(reto.getServicio()));
		
		assertNotNull(retoView);
	}
	
}
