package org.opi.sports.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.TipoServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.TipoServicioPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernandez
 *
 *Sprint 01 Descripción: Permite probar la funcionalidad al consultar
 *los establecimientos deportivo, desde el controller hasta el repositorio de
 *datos. La funcionalidad de estar a prueba, segun distintos escenarios
 *
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class EstablecimientoDeportivoTest {

	@Autowired
	private EstablecimientoDeportivoServiceInterface establecimientoService;
	
	
	/**
	 * Esta prueba permite saber si el servicio del Tipo Servicio se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getEstablecimientoDeportivoTest(){
		assertNotNull(establecimientoService);
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de Tipos de Servicios
	 */
	@Test
	public void getLisEstablecimientoDeportivoTest(){
		assertNotNull(establecimientoService.getAllEstablecimientos());
	}
	
	/**
	 * Prueba la implementación del controller
	 */
	@Test
	public void getEstablecimientoDeportivoGetAll(){
		
		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();
		
		List<EstablecimientoDeportivo> establecimientoDeportivoList = establecimientoService.getAllEstablecimientos();
		List<EstablecimientoDeportivoPOJO> establecimientoDeportivoViewList = new ArrayList<EstablecimientoDeportivoPOJO>();
		
		for(EstablecimientoDeportivo establecimiento : establecimientoDeportivoList){
			establecimientoDeportivoViewList.add(EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimiento));
		}
		
		establecimientoResponse.setEstablecimientoDeportivo(establecimientoDeportivoViewList);
		
		assertNotNull(establecimientoResponse);
	}
	/**
	 * Prueba la implementación del controller
	 */
	@Test
	public void getEstablecimientoDeportivofindOne(){
		//EstablecimientoDeportivo establecimientoDeportivo = establecimientoService.findOne(1);
		//assertNotNull(establecimientoDeportivo);
	}
	/**
	 * Prueba la implementación del controller
	 */
	@Test
	public void getEstablecimientoDeportivofindByUsuario(){

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		//EstablecimientoDeportivo establecimientoDeportivo = establecimientoService.findByUusario(usuario);
		//System.out.println(establecimientoDeportivo.getNombre());
		//assertNotNull(establecimientoDeportivo);
	}
	
}
