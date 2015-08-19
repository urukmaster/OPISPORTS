package org.opi.sports.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.ProvinciaResponse;
import org.opi.sports.ejb.Provincia;
import org.opi.sports.helpers.ProvinciaHelper;
import org.opi.sports.pojo.ProvinciaPOJO;
import org.opi.sports.services.ProvinciaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuración del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class ProvinciaTest {

	@Autowired
	ProvinciaServiceInterface provinciaService;
		
	/**
	 * Metodo encargado de solicitar todos las provincias
	 * 
	 */
	@Test
	public void getAll(){	
		
		ProvinciaResponse provinciaResponse = new ProvinciaResponse();

		List<Provincia> provinciaList = provinciaService.getAllProvincias();

		List<ProvinciaPOJO> provinciaViewList = new ArrayList<ProvinciaPOJO>();
		
		for(Provincia provincia : provinciaList){
			provinciaViewList.add(ProvinciaHelper.getInstance().convertirProvincia(provincia));
		}
		
		provinciaResponse.setProvincias(provinciaViewList);
		
		assertNotNull(provinciaResponse.getProvincia());
	}

}
