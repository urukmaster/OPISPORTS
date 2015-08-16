package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.contracts.ReservacionesResponse;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.ReservacionesHelper;
import org.opi.sports.pojo.CalendarioPOJO;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.services.TorneoServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 01 Descripción:Esta clase es la que contendrá cada uno de los
 *         servicios que serán necesarios para procesar la información de
 *         reservaciones de la aplicación
 *         
 * Fecha: 14-07-2015 version 1.1
 * 
 * @author Luis Esteban López Ramírez
 * 
 * Sprint 03 Descripción: Se agrega la funcionalidad para guardar las reservaciones
 * 
 */

@RestController
@RequestMapping(value = "rest/reservaciones")
public class ReservacionController {

	@Autowired
	ReservacionesServiceInterface reservacionesServices;

	@Autowired
	UsuarioServiceInterface usuarioServices;

	@Autowired
	ServicioServiceInterface servicioServices;

	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;

	@Autowired
	TorneoServiceInterface torneoService;
	
	/**
	 * Este método obtiene cada una de las instancias de reservaciones
	 * registradas en la base de datos
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ReservacionesResponse getAll() {

		ReservacionesResponse reservacionesResponse = new ReservacionesResponse();

		List<Reservaciones> reservacionesList = reservacionesServices
				.getAllReservaciones();

		List<ReservacionesPOJO> reservacionesViewList = new ArrayList<ReservacionesPOJO>();

		for (Reservaciones reservaciones : reservacionesList) {
			ReservacionesPOJO reservacionesView = new ReservacionesPOJO();
			PojoUtils.pojoMappingUtility(reservacionesView, reservaciones);
			reservacionesViewList.add(reservacionesView);
		}

		reservacionesResponse.setReservaciones(reservacionesViewList);

		return reservacionesResponse;

	}

	/**
	 * Este método se encarga de guardar las reservaciones
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public EstablecimientoDeportivoPOJO save(
			@RequestBody ReservacionesRequest reservacion) {

		ReservacionesPOJO reservacionView = ReservacionesHelper.getInstance()
				.saveReservacion(reservacion, reservacionesServices,
						usuarioServices.findOne(reservacion.getUsuario()),
						servicioServices.findOne(reservacion.getServicio()), torneoService);

		if (reservacionesServices.exists(reservacionView.getIdCalendario())) {
			List<ReservacionesPOJO> reservaciones = new ArrayList<ReservacionesPOJO>();
			reservaciones.add(reservacionView);
		}

		return EstablecimientoDeportivoHelper
				.getInstance()
				.convertirEstablecimiento(
						establecimientoDeportivoService.findOne(reservacion
								.getEstablecimiento()));
	}
	/**
	 * Se encarga de elminiar las reservaciones o torneos
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public EstablecimientoDeportivoPOJO delete(
			@RequestBody ReservacionesRequest reservacion) {
		
		Reservaciones reservacionesEJB = reservacionesServices.findOne(reservacion.getIdCalendario());
		reservacionesEJB.setActive((byte) 0);
		reservacionesServices.save(reservacionesEJB);

		return EstablecimientoDeportivoHelper
				.getInstance()
				.convertirEstablecimiento(
						establecimientoDeportivoService.findOne(reservacion
								.getEstablecimiento()));
	}
	/**
	 * Se encarga de modificar las reservaciones o torneos
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public EstablecimientoDeportivoPOJO update(
			@RequestBody ReservacionesRequest reservacion) {

		ReservacionesPOJO reservacionView = ReservacionesHelper.getInstance()
				.saveReservacion(reservacion, reservacionesServices,
						usuarioServices.findOne(reservacion.getUsuario()),
						servicioServices.findOne(reservacion.getServicio()), torneoService);

		if (reservacionesServices.exists(reservacionView.getIdCalendario())) {
			List<ReservacionesPOJO> reservaciones = new ArrayList<ReservacionesPOJO>();
			reservaciones.add(reservacionView);
		}
		
		EstablecimientoDeportivo establecimientoDeportivo = establecimientoDeportivoService.findOne(reservacion
				.getEstablecimiento());
		
		return EstablecimientoDeportivoHelper
				.getInstance()
				.convertirEstablecimiento(
						establecimientoDeportivo);
	}
	
	/**
	 * Se encarga de obtener las reservaciones o torneos
	 */
	@RequestMapping(value = "getReservacion", method = RequestMethod.POST)
	public ReservacionesResponse getReservacion(@RequestBody ReservacionesRequest reservacionRequest){
		return ReservacionesHelper.getInstance().getReservacion(reservacionRequest.getIdCalendario(), reservacionesServices);
	}
	
	
	
}