package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.InscripcionResponse;
import org.opi.sports.ejb.Inscripcion;
import org.opi.sports.helpers.InscripcionHelper;
import org.opi.sports.pojo.InscripcionPOJO;
import org.opi.sports.services.InscripcionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 16-08-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 06 Descripción:Esta clase es la que contendrá cada uno de los
 *         servicios que serán necesarios para procesar la información de las
 *         inscripciones a eventos deportivos
 */

@RestController
@RequestMapping(value = "rest/inscripcion")
public class InscripcionController {

	@Autowired
	InscripcionServiceInterface inscripcionServices;

	/**
	 * Este método obtiene cada una de las instancias de inscripciones
	 * registradas en la base de datos
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public InscripcionResponse getAll() {

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

		return inscripcionResponse;

	}

}
