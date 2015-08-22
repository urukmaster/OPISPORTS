package org.opi.sports.controllers;

import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.contracts.ServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.ServicioHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.services.ActividadDeportivaServiceInterface;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 20-07-2015
 * 
 * Revision: 1.0 Sprint 03
 * 
 * @author Luis Esteban López Ramírez
 * 
 *         Descripción: Controller para que el front end se comunique con los
 *         servicios del sistema, para modificar, guardar o eliminar los
 *         servicios de un establecimiento deportivo
 *
 */
@RestController
@RequestMapping(value = "rest/servicio")
public class ServicioController {

	@Autowired
	ServicioServiceInterface servicioService;

	@Autowired
	TipoServicioServiceInterface tipoServicioService;

	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;

	@Autowired
	ActividadDeportivaServiceInterface actividadDeportivaService;

	/**
	 * Se encarga de guardar o modificar los servicios
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ServicioResponse save(
			@RequestBody ServicioRequest servicioRequest) {

		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();

		EstablecimientoDeportivo establecimientoDeportivoEJB = null;

		ServicioResponse servicioResponse = new ServicioResponse();

		try {

			TipoServicio tipoServicioEJB = tipoServicioService
					.findOne(servicioRequest.getTipoServicio());

			establecimientoDeportivoEJB = establecimientoDeportivoService
					.findOne(servicioRequest.getEstablecimiento());

			servicioResponse.setServicio(ServicioHelper.getInstance()
					.saveServicio(servicioRequest, tipoServicioEJB,
							servicioService, actividadDeportivaService,
							establecimientoDeportivoEJB));

			servicioResponse.setCode(200);
			servicioResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			servicioResponse.setCode(404);
			servicioResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			servicioResponse.setErrorMessage(exception.getMessage());
		}

		return servicioResponse;
	}

	/**
	 * Se encarga de eliminar los servicios
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public EstablecimientoDeportivoResponse delete(
			@RequestBody ServicioRequest servicioRequest) {

		EstablecimientoDeportivoResponse establecimientoResponse = new EstablecimientoDeportivoResponse();

		ServicioResponse servicioResponse = new ServicioResponse();

		try {

			servicioResponse.setServicio(ServicioHelper.getInstance()
					.deleteServicio(servicioRequest, servicioService));

			servicioResponse.setCode(200);
			servicioResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			servicioResponse.setCode(404);
			servicioResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			servicioResponse.setErrorMessage(exception.getMessage());
		} finally {
			if (servicioResponse.getCode() == 200) {
				establecimientoResponse
						.setEstablecimientoDeportivo(EstablecimientoDeportivoHelper
								.getInstance().convertirEstablecimiento(
										establecimientoDeportivoService
												.findOne(servicioRequest
														.getEstablecimiento())));
				establecimientoResponse.setCode(200);
				establecimientoResponse.setCodeMessage("Operación Exitosa");
			} else {
				establecimientoResponse.setCode(404);
				establecimientoResponse.setCodeMessage(servicioResponse
						.getCodeMessage());
				establecimientoResponse.setErrorMessage(servicioResponse
						.getErrorMessage());
			}

		}

		return establecimientoResponse;

	}

	// @RequestMapping(value = "findOne", method = RequestMethod.POST)
	// public findOne(@RequestBody ServicioRequest servicioRequest) {
	//
	// ServicioResponse servicioResponse = new ServicioResponse();
	//
	// servicioResponse.setServicio(ServicioHelper.getInstance().deleteServicio(
	// servicioRequest, servicioService));
	//
	// return
	// EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimientoDeportivoService
	// .findOne(servicioRequest.getEstablecimiento()));
	//
	// }
}
