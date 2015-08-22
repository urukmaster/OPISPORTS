package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ActividadDeportivaRequest;
import org.opi.sports.contracts.ActividadDeportivaResponse;
import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.contracts.ReservacionesResponse;
import org.opi.sports.contracts.RetoRequest;
import org.opi.sports.contracts.RetoResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.ActividadDeportivaHelper;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.helpers.RetoHelper;
import org.opi.sports.pojo.ActividadDeportivaPOJO;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetoPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.RetoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
//import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 28-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *         Sprint 04 Descripción: Clase controller de los establecimientos
 *
 */
@RestController
@RequestMapping(value = "rest/reto")
public class RetoController {

	@Autowired
	RetoServiceInterface retoService;
	@Autowired
	UsuarioServiceInterface usuarioService;
	@Autowired
	ServicioServiceInterface servicioService;

	/**
	 * Metodo encargado de obtener todos los retos
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public RetoResponse getAll() {

		RetoResponse retoResponse = new RetoResponse();

		try {

			List<Reto> retoList = retoService.getAllRetos();

			List<RetosPOJO> retospojo = new ArrayList<RetosPOJO>();

			retospojo = RetoHelper.getInstance().convertirReto(retoList);

			retoResponse.setRetospojo(retospojo);
			retoResponse.setCode(200);
			retoResponse.setCodeMessage("Operación exitosa");

		} catch (Exception exception) {
			retoResponse.setCode(404);
			retoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			retoResponse.setErrorMessage(exception.getMessage());
		}

		return retoResponse;
	}
	/**
	 * Metodo encargado de registrar los retos
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public RetoResponse save(@RequestBody RetoRequest retoRequest) {
		RetoResponse retoResponse = new RetoResponse();

		try {

			RetoPOJO retopojo = RetoHelper.getInstance().saveReto(retoRequest,
					retoService,
					usuarioService.findOne(retoRequest.getUsuario()),
					servicioService.findOne(retoRequest.getServicio()));

			List<Reto> retoList = retoService.getAllRetos();
			List<RetosPOJO> retospojo = new ArrayList<RetosPOJO>();
			retospojo = RetoHelper.getInstance().convertirReto(retoList);

			if (retoService.exists(retopojo.getIdReto())) {
				retoResponse.setRetospojo(retospojo);
				retoResponse.setCode(200);
				retoResponse.setCodeMessage("El reto se publico correctamente");
			} else {
				retoResponse.setCode(401);
				retoResponse.setCodeMessage("El reto no se publico");
			}
		} catch (Exception exception) {
			retoResponse.setCode(404);
			retoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			retoResponse.setErrorMessage(exception.getMessage());
		}

		return retoResponse;
	}

	/**
	 * Metodo encargado de modificar los retos
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public RetoResponse update(@RequestBody RetoRequest retoRequest) {

		RetoResponse retoResponse = new RetoResponse();

		try {

			RetoPOJO retopojo = RetoHelper.getInstance().updateReto(
					retoRequest, retoService,
					usuarioService.findOne(retoRequest.getUsuario()),
					servicioService.findOne(retoRequest.getServicio()));

			List<Reto> retoList = retoService.getAllRetos();
			List<RetosPOJO> retospojo = new ArrayList<RetosPOJO>();
			retospojo = RetoHelper.getInstance().convertirReto(retoList);

			if (retoService.exists(retopojo.getIdReto())) {
				retoResponse.setRetospojo(retospojo);
				retoResponse.setCode(200);
				retoResponse
						.setCodeMessage("El reto se modifico correctamente");
			} else {
				retoResponse.setCode(401);
				retoResponse.setCodeMessage("El reto no se modifico");
			}

		} catch (Exception exception) {
			retoResponse.setCode(404);
			retoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			retoResponse.setErrorMessage(exception.getMessage());
		}

		return retoResponse;

	}

	/**
	 * Metodo encargado de eliminar los retos
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public RetoResponse delete(@RequestBody RetoRequest retoRequest) {

		RetoResponse retoResponse = new RetoResponse();
		try {
			RetoPOJO retopojo = RetoHelper.getInstance().deleteReto(
					retoRequest, retoService,
					usuarioService.findOne(retoRequest.getUsuario()),
					servicioService.findOne(retoRequest.getServicio()));

			List<Reto> retoList = retoService.getAllRetos();
			List<RetosPOJO> retospojo = new ArrayList<RetosPOJO>();
			retospojo = RetoHelper.getInstance().convertirReto(retoList);

			if (retoService.exists(retopojo.getIdReto())) {
				retoResponse.setRetospojo(retospojo);
				retoResponse.setCode(200);
				retoResponse
						.setCodeMessage("El reto se elimino correctamente");
			} else {
				retoResponse.setCode(401);
				retoResponse.setCodeMessage("El reto no se elimino");
			}

		} catch (Exception exception) {
			retoResponse.setCode(404);
			retoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			retoResponse.setErrorMessage(exception.getMessage());
		}

		return retoResponse;
	}

}
