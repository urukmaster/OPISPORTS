package org.opi.sports.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.InscripcionResponse;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.helpers.InscripcionHelper;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.services.InscripcionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuracion del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class InscripcionTest {


	@Autowired
	InscripcionServiceInterface inscripcionServices;

	/**
	 * Este método obtiene cada una de las instancias de inscripciones
	 * registradas en la base de datos
	 */
	@Test
	public void getAll() {

		InscripcionResponse inscripcionResponse = new InscripcionResponse();

		try {

			List<Inscripcion> inscripcionList = inscripcionServices
					.getAllInscripciones();
			List<InscripcionPOJO> inscripcionViewList = new ArrayList<InscripcionPOJO>();

			for (Inscripcion inscripcion : inscripcionList) {
				inscripcionViewList.add(InscripcionHelper.getInstance()
						.convertirInscripcion(inscripcion));
			}

			inscripcionResponse.setInscripciones(inscripcionViewList);

			inscripcionResponse.setCode(200);
			inscripcionResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			inscripcionResponse.setCode(404);
			inscripcionResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			inscripcionResponse.setErrorMessage(exception.getMessage());
		}

		assertTrue(inscripcionResponse.getCode() ==200);

	}
	
}
