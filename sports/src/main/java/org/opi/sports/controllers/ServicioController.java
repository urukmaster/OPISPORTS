package org.opi.sports.controllers;

import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.contracts.ServicioResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.helpers.ServicioHelper;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/servicio")
public class ServicioController {

	@Autowired
	ServicioServiceInterface servicioService;

	@Autowired
	TipoServicioServiceInterface tipoServicioService;

	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ServicioResponse save(@RequestBody ServicioRequest servicioRequest) {

		ServicioResponse servicioResponse = new ServicioResponse();

		TipoServicio tipoServicioEJB = tipoServicioService
				.findOne(servicioRequest.getTipoServicio());

		EstablecimientoDeportivo establecimientoDeportivoEJB = establecimientoDeportivoService
				.findOne(servicioRequest.getEstablecimiento());

		servicioResponse.setServicio(ServicioHelper.getInstance().saveServicio(
				servicioRequest, establecimientoDeportivoEJB, tipoServicioEJB,
				servicioService));

		return servicioResponse;

	}
}
