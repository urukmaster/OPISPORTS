package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.contracts.ServicioRequest;
import org.opi.sports.ejb.Distrito;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Evento;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Reto;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Torneo;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.RetosPOJO;
import org.opi.sports.pojo.ReviewsPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.pojo.TorneoPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 17-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández Sprint 02 Descripción: Helper de
 *         establecimientos deportivos
 *
 */
public class EstablecimientoDeportivoHelper {

	private static EstablecimientoDeportivoHelper instance;

	private EstablecimientoDeportivoHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new EstablecimientoDeportivoHelper();
		}
	}

	public static EstablecimientoDeportivoHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	/**
	 * Metodo que se encarga de convertir un establecimiento EJB a POJO con
	 * todas las relaciones correspondientes
	 */
	public EstablecimientoDeportivoPOJO convertirEstablecimiento(
			EstablecimientoDeportivo establecimiento) {

		EstablecimientoDeportivoPOJO establecimientoView = new EstablecimientoDeportivoPOJO();

		PojoUtils.pojoMappingUtility(establecimientoView, establecimiento);

		List<ServicioPOJO> servicios = new ArrayList<ServicioPOJO>();

		List<TorneoPOJO> torneos = new ArrayList<TorneoPOJO>();

		for (Servicio servicio : establecimiento.getServicios()) {
			if (servicio.getActive() == 1) {
				servicios.add(convertirServicios(servicio));
				for (Reservaciones reservacion : servicio.getReservaciones()) {
					if (reservacion.getTorneo() != null) {
						TorneoPOJO torneo = new TorneoPOJO();
						PojoUtils.pojoMappingUtility(torneo,
								reservacion.getTorneo());
						SimpleDateFormat convertirHora = new SimpleDateFormat(
								"HH:mm");
						SimpleDateFormat convertirFecha = new SimpleDateFormat(
								"dd-MM-yyyy");

						torneo.setStart(convertirFecha(convertirFecha
								.format(reservacion.getFecha())
								+ " "
								+ convertirHora.format(reservacion.getHora()
										.getTime())));
						Calendar sumarHora = Calendar.getInstance();
						sumarHora.setTime(reservacion.getHora());
						sumarHora.add(Calendar.HOUR_OF_DAY, reservacion.getTorneo().getHorasTorneos());
						
						torneo.setEnd(convertirFecha(convertirFecha
								.format(reservacion.getFecha())
								+ " "
								+ convertirHora.format(sumarHora.getTime())));
						
						torneos.add(torneo);
					}
				}
			}

		}

		establecimientoView.setTorneos(torneos);

		List<ReviewsPOJO> reviews =  new ArrayList<ReviewsPOJO>();
		
		reviews = obtenerReviews(establecimiento);
		
		establecimientoView.setReviews(reviews);
		establecimientoView.setServicios(servicios);
		establecimientoView.setCalendario();
		establecimientoView.setPendientes();
		establecimientoView.setIdUsuario(establecimiento.getUsuario().getIdUsuario());
		return establecimientoView;
	}

	private List<ReviewsPOJO> obtenerReviews(EstablecimientoDeportivo establecimiento) {
		List<ReviewsPOJO> reviews =  new ArrayList<ReviewsPOJO>();
		for(Review review : establecimiento.getReviews()){
			if(review.getActive() == 1){
			reviews.add(convertirReview(review));
			}
		}
		return reviews;
	}

	private ReviewsPOJO convertirReview(Review preview) {
		ReviewsPOJO reviewpojo = new ReviewsPOJO();
		reviewpojo.setIdComentario(preview.getIdComentario());
		reviewpojo.setReview(preview.getReview());
		reviewpojo.setIdEstablecimientoDeportivo(preview.getEstablecimientoDeportivo().getIdEstablecimientoDeportivo());
		reviewpojo.setNombreUsuario(preview.getUsuario().getNombre());
		reviewpojo.setApellidoUsuario(preview.getUsuario().getApellido());
		reviewpojo.setIdUsuario(preview.getUsuario().getIdUsuario());
		reviewpojo.setActive(preview.getActive());
		
		return reviewpojo;
	}

	/*
	 * Este metodo de convertir a fecha para manejo del sistema.
	 */
	private DateTime convertirFecha(String fecha) {
		DateTimeFormatter convertirFechaHora = DateTimeFormat
				.forPattern("dd-MM-yyyy HH:mm");
		return convertirFechaHora.parseDateTime(fecha);

	}

	/**
	 * Metodo que convierte un servicio EJB a POJO
	 */
	private ServicioPOJO convertirServicios(Servicio servicio) {

		ServicioPOJO servicioView = new ServicioPOJO();
		PojoUtils.pojoMappingUtility(servicioView, servicio);

		List<ReservacionesPOJO> reservaciones = new ArrayList<ReservacionesPOJO>();

		for (Reservaciones reservacion : servicio.getReservaciones()) {
			if (reservacion.getActive() == (byte) 1) {
				reservaciones.add(convertirReservaciones(reservacion));
			}
		}


		servicioView.setReservacionesLista(reservaciones);

		servicioView.setHoraInicial(new DateTime(servicio.getHoraApertura()));
		servicioView.setHoraFinal(new DateTime(servicio.getHoraCierre()));

		return servicioView;
	}

	/**
	 * Metodo que se encarga una reservacion EJB a pojo
	 */
	private ReservacionesPOJO convertirReservaciones(Reservaciones reservacion) {

		ReservacionesPOJO reservacionesPOJO = new ReservacionesPOJO();

		PojoUtils.pojoMappingUtility(reservacionesPOJO, reservacion);

		if (reservacion.getTorneo() != null) {
			TorneoPOJO torneoPOJO = new TorneoPOJO();
			PojoUtils.pojoMappingUtility(torneoPOJO, reservacion.getTorneo());
			reservacionesPOJO.setTorneo(torneoPOJO);
		}

		return reservacionesPOJO;
	}

	/**
	 * Metodo encargado de registrar el establecimiento deportivo
	 * 
	 */
	public EstablecimientoDeportivoPOJO saveEstablecimiento(
			EstablecimientoDeportivoRequest establecimientoRequest,
			EstablecimientoDeportivoServiceInterface establecimientoService) {
            EstablecimientoDeportivo establecimientoEJB = new EstablecimientoDeportivo();


		if (establecimientoRequest.getAccion().equals("Modificar")) {
			establecimientoEJB
					.setIdEstablecimientoDeportivo(establecimientoRequest
							.getIdEstablecimientoDeportivo());
		}

		establecimientoEJB.setNombre(establecimientoRequest.getNombre());
		establecimientoEJB.setDireccion(establecimientoRequest.getDireccion());
		establecimientoEJB.setTelefono(establecimientoRequest.getTelefono());
		establecimientoEJB.setPaginaWeb(establecimientoRequest.getPaginaWeb());
		
		Distrito distrito = new Distrito();
		distrito.setIdDistrito(establecimientoRequest.getIdDistrito());
		establecimientoEJB.setDistrito(distrito);
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(establecimientoRequest.getIdUsuario());
		establecimientoEJB.setUsuario(usuario);
		establecimientoEJB.setActive((byte)1);
		
		EstablecimientoDeportivoPOJO establecimientoPOJO = new EstablecimientoDeportivoPOJO();

		PojoUtils.pojoMappingUtility(establecimientoPOJO,
				establecimientoService.save(establecimientoEJB));

		return establecimientoPOJO;
	}

}
