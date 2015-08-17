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
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TorneoServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora
 *
 *Sprint 01 Descripción: Permite probar la funcionalidad al consultar
 *las reservaciones, desde el controller hasta el repositorio de
 *datos. La funcionalidad debe estar a prueba, segun distintos escenarios
 *
 *
 *Fecha: 14-07-2015 version 1.1
 *
 *@author Luis Esteban López Ramírez
 *
 *Sprint #3 Descripción: Permite probar que las reservaciones se guarden correctamente
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuración del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class ReservacionesTest {

	@Autowired
	private ReservacionesServiceInterface reservacionesService;
	
	@Autowired
	UsuarioServiceInterface usuarioServices;

	@Autowired
	ServicioServiceInterface servicioServices;
	
	@Autowired
	TorneoServiceInterface torneoService;
	
	/**
	 * Esta prueba permite saber si el servicio de Reservaciones se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getTipoServicioServiceTest(){
		assertNotNull(reservacionesService);
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de Tipos de Servicios
	 */
	//@Test
	public void getLisTipoServicioTest(){
		assertNotNull(reservacionesService.getAllReservaciones());
	}
	
	/**
	 * Prueba la implementación del controller
	 */
	//@Test
	public void getTipoServicioControllerGetAll(){
		
		ReservacionesResponse reservacionesResponse = new ReservacionesResponse();
		
		List<Reservaciones> reservacionesList = reservacionesService.getAllReservaciones();
		List<ReservacionesPOJO> reservacionesViewList = new ArrayList<ReservacionesPOJO>();
		
		for(Reservaciones reservaciones : reservacionesList){
			ReservacionesPOJO reservacionesView = new ReservacionesPOJO();
			PojoUtils.pojoMappingUtility(reservacionesView, reservaciones);
			reservacionesViewList.add(reservacionesView);
		}
		
		reservacionesResponse.setReservaciones(reservacionesViewList);
		
		assertNotNull(reservacionesResponse);
	}
	/**
	 * Prueba para guardar reservaciones
	 */
	//@Test
	public void saveReservaciones(){
		ReservacionesRequest reservacion = new ReservacionesRequest();
		reservacion.setFecha(new Date());
		reservacion.setHora(new Time(new Date().getTime()));
		reservacion.setEstado("Pendiente");
		reservacion.setUsuario(1);
		reservacion.setServicio(1);
		reservacion.setAccion("Reservar");
		reservacion.setTorneo(false);
		
		ReservacionesPOJO reservacionView = ReservacionesHelper.getInstance().saveReservacion(reservacion, reservacionesService,
				usuarioServices.findOne(reservacion.getUsuario()), servicioServices.findOne(reservacion.getServicio()), torneoService);
		
		assertNotNull(reservacionView);
	}
	
}
