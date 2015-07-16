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
 * Fecha: 13-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *Sprint 01 Descripción: Permite probar la funcionalidad al consultar
 *los estalecimientos deportivos, desde el controller hasta el repositorio de
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
	private EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;
	
	
	/**
	 * Esta prueba permite saber si el servicio del establecimiento deportivo se inyecta al
	 * ejecutar la prueba, esto para probar la funcionalidad del Spring al hacer
	 * "Autowired"
	 */
	@Test
	public void getEstablecimientoDeportivoServiceTest(){
		assertNotNull(establecimientoDeportivoService);
	}
	
	/**
	 * Esta prueba permite realizar la consulta a la base de datos mediante el servicio
	 * el cual va a traer una lista de establecimientos deportivos
	 */
	@Test
	public void getLisEstablecimientoDeportivoTest(){
		assertNotNull(establecimientoDeportivoService.getAllEstablecimientos());
	}
	
	/**
	 * Prueba la implementación del controller
	 */
	@Test
	public void getEstablecimientoControllerGetAll(){
		
		EstablecimientoDeportivoResponse establecimientoDeportivoResponse = new EstablecimientoDeportivoResponse();
		
		List<EstablecimientoDeportivo> establecimientoDeportivoList = establecimientoDeportivoService.getAllEstablecimientos();
		List<EstablecimientoDeportivoPOJO> establecimientoDeportivoViewList = new ArrayList<EstablecimientoDeportivoPOJO>();
		
		for(EstablecimientoDeportivo establecimientoDeportivo : establecimientoDeportivoList){
			EstablecimientoDeportivoPOJO estblecimientoDeportivoView = new EstablecimientoDeportivoPOJO();
			PojoUtils.pojoMappingUtility(estblecimientoDeportivoView, establecimientoDeportivo);
			establecimientoDeportivoViewList.add(estblecimientoDeportivoView);
		}
		
		establecimientoDeportivoResponse.setEstablecimientoDeportivo(establecimientoDeportivoViewList);
		
		assertNotNull(establecimientoDeportivoResponse);
	}
	/**
	 * Prueba que permite registrar una establecimiento deportivo
	 */
    @Test
    public void saveEstablecimientoDeportivo()
    {
        EstablecimientoDeportivo establecimiento = new EstablecimientoDeportivo();
        establecimiento.setNombre("Particular");
        establecimiento.setDireccion("Prueba");
        establecimiento.setPaginaWeb("Prueba");
        establecimiento.setTelefono("Prueba");
        
        Boolean state = establecimientoDeportivoService.saveEstablecimiento(establecimiento);
        
        EstablecimientoDeportivo establecimientoresponse = establecimientoDeportivoService.findByName("Particular");
        
        System.out.println(establecimientoresponse.getNombre());
 
		if(state){
			System.out.println("Registrado");
		}
    }
}

