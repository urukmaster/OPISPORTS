package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.contracts.ActividadDeportivaResponse;
import org.opi.sports.ejb.ActividadDeportiva;
import org.opi.sports.helpers.ActividadDeportivaHelper;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 29-07-2015
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *         Sprint #4 Descripción: Se encarga de gestionar las actividades
 *         deportivas desde el front end, segun las peticiones por parte de la
 *         aplicación.
 */
@RestController
@RequestMapping(value = "rest/actividadDeportiva")
public class ActividadDeportivaController {

	@Autowired
	ActividadDeportivaServiceInterface actividadDeportivaService;

	/**
	 * Este método se encarga de guardar las actividades depotivas
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ActividadDeportivaResponse save(
			@RequestBody ActividadDeportivaRequest actividadDeportivaRequest) {

		// Actividad Deportiva Response
		ActividadDeportivaResponse actividadDeportivaResponse = new ActividadDeportivaResponse();
		try {
			// Actividad Deportiva POJO
			ActividadDeportivaPOJO actividadDeportivaView = ActividadDeportivaHelper
					.getInstance().saveActividadDeportiva(
							actividadDeportivaRequest,
							actividadDeportivaService);

			if (actividadDeportivaService.exists(actividadDeportivaView
					.getIdActividadDeportiva())) {
				actividadDeportivaResponse.setCode(200);
				actividadDeportivaResponse
						.setCodeMessage("La actividad deportiva se registro correctamente");
			} else {
				actividadDeportivaResponse.setCode(401);
				actividadDeportivaResponse
						.setCodeMessage("La actividad deportiva no se registro");
			}

			// Inicializacion de las actividades

			// Lista de actividades deportivas
			List<ActividadDeportiva> actividadDeportivaList = actividadDeportivaService
					.getAllActividadDeportiva();
			// Lista de EstablecimientoDeportivoPOJO
			List<ActividadDeportivaPOJO> actividadDeportivaViewList = new ArrayList<ActividadDeportivaPOJO>();

			for (ActividadDeportiva actividadDeportiva : actividadDeportivaList) {
				actividadDeportivaViewList.add(ActividadDeportivaHelper
						.getInstance().convertirActividadDeportiva(
								actividadDeportiva));
			}

			actividadDeportivaResponse
					.setActividadesDeportivas(actividadDeportivaViewList);
			actividadDeportivaResponse.setCode(200);
			actividadDeportivaResponse.setCodeMessage("Operación exitosa");
		} catch (Exception exception) {
			actividadDeportivaResponse.setCode(404);
			actividadDeportivaResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			actividadDeportivaResponse.setErrorMessage(exception.getMessage());
		}

		return actividadDeportivaResponse;

	}

	/**
	 * Este método se encarga de modificar los usuarios
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ActividadDeportivaResponse update(
			@RequestBody ActividadDeportivaRequest actividadDeportivaRequest) {
		// Inicializacion de las actividades

		// Lista de EstablecimientoDeportivoPOJO
		List<ActividadDeportivaPOJO> actividadDeportivaViewList = new ArrayList<ActividadDeportivaPOJO>();
		// Actividad Deportiva Response
		ActividadDeportivaResponse actividadDeportivaResponse = new ActividadDeportivaResponse();

		try {
			// Actividad Deportiva POJO
			ActividadDeportivaPOJO actividadDeportivaView = ActividadDeportivaHelper
					.getInstance().updateActividadDeportiva(
							actividadDeportivaRequest,
							actividadDeportivaService);

			if (actividadDeportivaService.exists(actividadDeportivaView
					.getIdActividadDeportiva())) {
				actividadDeportivaResponse.setCode(200);
				actividadDeportivaResponse
						.setCodeMessage("La actividad deportiva se actualizo correctamente");
			} else {
				actividadDeportivaResponse.setCode(401);
				actividadDeportivaResponse
						.setCodeMessage("La actividad deportiva no se actualizo");
			}
			// Variable de tipo EstablecimientoDeportivoResponse
			List<ActividadDeportiva> actividadDeportivaList = actividadDeportivaService
					.getAllActividadDeportiva();
			for (ActividadDeportiva actividadDeportiva : actividadDeportivaList) {
				actividadDeportivaViewList.add(ActividadDeportivaHelper
						.getInstance().convertirActividadDeportiva(
								actividadDeportiva));
			}

			actividadDeportivaResponse
					.setActividadesDeportivas(actividadDeportivaViewList);
			actividadDeportivaResponse.setCode(200);
			actividadDeportivaResponse.setCodeMessage("Operación exitosa");
		} catch (Exception exception) {
			actividadDeportivaResponse.setCode(404);
			actividadDeportivaResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			actividadDeportivaResponse.setErrorMessage(exception.getMessage());
		}

		return actividadDeportivaResponse;

	}

	/**
	 * Este método se encarga de modificar los usuarios
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ActividadDeportivaResponse delete(
			@RequestBody ActividadDeportivaRequest actividadDeportivaRequest) {

		// Actividad Deportiva Response
		ActividadDeportivaResponse actividadDeportivaResponse = new ActividadDeportivaResponse();
		try {
			// Actividad Deportiva POJO
			ActividadDeportivaPOJO actividadDeportivaView = ActividadDeportivaHelper
					.getInstance().deleteActividadDeportiva(
							actividadDeportivaRequest,
							actividadDeportivaService);

			if (actividadDeportivaService.exists(actividadDeportivaView
					.getIdActividadDeportiva())) {
				List<ActividadDeportivaPOJO> actividadesDeportivas = new ArrayList<ActividadDeportivaPOJO>();
				actividadesDeportivas.add(actividadDeportivaView);
				actividadDeportivaResponse
						.setActividadesDeportivas(actividadesDeportivas);
				actividadDeportivaResponse.setCode(200);
				actividadDeportivaResponse
						.setCodeMessage("La actividad deportiva se elimino correctamente");
			} else {
				actividadDeportivaResponse.setCode(401);
				actividadDeportivaResponse
						.setCodeMessage("La actividad deportiva no se elimino");
			}

			// Inicializacion de las actividades

			// Variable de tipo EstablecimientoDeportivoResponse
			List<ActividadDeportiva> actividadDeportivaList = actividadDeportivaService
					.getAllActividadDeportiva();
			// Lista de EstablecimientoDeportivoPOJO
			List<ActividadDeportivaPOJO> actividadDeportivaViewList = new ArrayList<ActividadDeportivaPOJO>();

			for (ActividadDeportiva actividadDeportiva : actividadDeportivaList) {
				actividadDeportivaViewList.add(ActividadDeportivaHelper
						.getInstance().convertirActividadDeportiva(
								actividadDeportiva));
			}

			actividadDeportivaResponse
					.setActividadesDeportivas(actividadDeportivaViewList);

			actividadDeportivaResponse.setCode(200);
			actividadDeportivaResponse.setCodeMessage("Operación exitosa");
		} catch (Exception exception) {
			actividadDeportivaResponse.setCode(404);
			actividadDeportivaResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			actividadDeportivaResponse.setErrorMessage(exception.getMessage());
		}

		return actividadDeportivaResponse;

	}

	/**
	 * Metodo encargado de solicitar todos las actividades deportivas
	 * 
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ActividadDeportivaResponse getAll() {

		// Variable de tipo EstablecimientoDeportivoResponse
		ActividadDeportivaResponse actividadDeportivaResponse = new ActividadDeportivaResponse();
		try {
			// Lista de tipo EstablecimientoDeportivo
			List<ActividadDeportiva> actividadDeportivaList = actividadDeportivaService
					.getAllActividadDeportiva();
			// Lista de EstablecimientoDeportivoPOJO
			List<ActividadDeportivaPOJO> actividadDeportivaViewList = new ArrayList<ActividadDeportivaPOJO>();

			for (ActividadDeportiva actividadDeportiva : actividadDeportivaList) {
				actividadDeportivaViewList.add(ActividadDeportivaHelper
						.getInstance().convertirActividadDeportiva(
								actividadDeportiva));
			}

			actividadDeportivaResponse
					.setActividadesDeportivas(actividadDeportivaViewList);
			actividadDeportivaResponse.setCode(200);
			actividadDeportivaResponse.setCodeMessage("Operación exitosa");
		} catch (Exception exception) {
			actividadDeportivaResponse.setCode(404);
			actividadDeportivaResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			actividadDeportivaResponse.setErrorMessage(exception.getMessage());
		}

		return actividadDeportivaResponse;
	}

}
