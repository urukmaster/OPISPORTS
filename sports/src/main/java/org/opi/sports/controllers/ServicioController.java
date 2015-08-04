package org.opi.sports.controllers;

import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.contracts.ServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.ServicioHelper;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 20-07-2015 
 * 
 * Revision: 1.0 Sprint 03
 * 
 * @author Luis Esteban López Ramírez
 * 
 * Descripción: Controller para que el front end se comunique con los servicios
 * del sistema, para modificar, guardar o eliminar los servicios de un establecimiento
 * deportivo
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

	/**
	 * Se encarga de guardar o modificar los servicios
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public EstablecimientoDeportivoPOJO save(@RequestBody ServicioRequest servicioRequest) {

		ServicioResponse servicioResponse = new ServicioResponse();

		TipoServicio tipoServicioEJB = tipoServicioService
				.findOne(servicioRequest.getTipoServicio());


		servicioResponse.setServicio(ServicioHelper.getInstance().saveServicio(
				servicioRequest, tipoServicioEJB,
				servicioService));

		return EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimientoDeportivoService
				.findOne(servicioRequest.getEstablecimiento()));


	}
	/**
	 * Se encarga de eliminar los servicios
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public EstablecimientoDeportivoPOJO delete(@RequestBody ServicioRequest servicioRequest) {

		ServicioResponse servicioResponse = new ServicioResponse();

		servicioResponse.setServicio(ServicioHelper.getInstance().deleteServicio(
				servicioRequest, servicioService));

		return EstablecimientoDeportivoHelper.getInstance().convertirEstablecimiento(establecimientoDeportivoService
				.findOne(servicioRequest.getEstablecimiento()));

	}
}
