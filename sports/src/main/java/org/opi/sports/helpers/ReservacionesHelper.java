package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opi.sports.contracts.ReservacionesRequest;
import org.opi.sports.ejb.Reservaciones;
import org.opi.sports.ejb.Servicio;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.CalendarioPOJO;
import org.opi.sports.pojo.ReservacionesPOJO;
import org.opi.sports.pojo.ServicioPOJO;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.utils.PojoUtils;

/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 01 Descripción:Esta clase sirve de apoyo a la clase de
 *         ReservacionesController y contiene la lógica necesaria para
 *         serializar las reservaciones y poder mostrarlas en el front end Esta
 *         clase se implementa como "Singleton" para asegurarnos que sea
 *         instanciada una sola vez.
 */

public class ReservacionesHelper {

	private static ReservacionesHelper instance;

	private ReservacionesHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new ReservacionesHelper();
		}
	}

	public static ReservacionesHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	/**
	 * Este método serializa cada uno de los atributos de "Reservaciones" para
	 * poder utilizarlos en el front end como un JSON
	 */
	public List<CalendarioPOJO> calendarioSerializer(
			List<ServicioPOJO> listaServiciosView) {

		List<CalendarioPOJO> calendario = new ArrayList<CalendarioPOJO>();

		for (ServicioPOJO servicioView : listaServiciosView) {
			for (ReservacionesPOJO reservacionView : servicioView
					.getReservaciones()) {
				if (reservacionView.getEstado().equals("Reservado")) {
					CalendarioPOJO reservacion = new CalendarioPOJO();

					SimpleDateFormat convertirHora = new SimpleDateFormat(
							"HH:mm");
					SimpleDateFormat convertirFecha = new SimpleDateFormat(
							"dd-MM-yyyy");

					Calendar sumarHora = Calendar.getInstance();
					sumarHora.setTime(reservacionView.getHora());
					sumarHora.add(Calendar.HOUR_OF_DAY, 1);

					reservacion.setIdCalendario(reservacionView.getIdCalendario());
					reservacion.setTitle(servicioView.getServicio());
					reservacion.setStart(convertirFecha(convertirFecha
							.format(reservacionView.getFecha())
							+ " "
							+ convertirHora.format(reservacionView.getHora()
									.getTime())));
					reservacion.setEnd(convertirFecha(convertirFecha
							.format(reservacionView.getFecha())
							+ " "
							+ convertirHora.format(sumarHora.getTime())));
					reservacion.setBackgroundColor("#f56954");
					reservacion.setBorderColor("#f56954");

					calendario.add(reservacion);
				}
			}
		}

		return calendario;
	}

	/**
	 * Este método serializa cada uno de los atributos de "Reservaciones" para
	 * poder utilizarlos en el front end como un JSON
	 */
	public List<CalendarioPOJO> reservacionesPendientes(
			List<ServicioPOJO> listaServiciosView) {

		List<CalendarioPOJO> calendario = new ArrayList<CalendarioPOJO>();

		for (ServicioPOJO servicioView : listaServiciosView) {
			for (ReservacionesPOJO reservacionView : servicioView
					.getReservaciones()) {
				if (reservacionView.getEstado().equals("Pendiente")) {
					CalendarioPOJO reservacion = new CalendarioPOJO();

					SimpleDateFormat convertirHora = new SimpleDateFormat(
							"HH:mm");
					SimpleDateFormat convertirFecha = new SimpleDateFormat(
							"dd-MM-yyyy");

					Calendar sumarHora = Calendar.getInstance();
					sumarHora.setTime(reservacionView.getHora());
					sumarHora.add(Calendar.HOUR_OF_DAY, 1);
					
					reservacion.setServicio(servicioView.getIdServicio());
					reservacion.setIdCalendario(reservacionView.getIdCalendario());
					reservacion.setTitle(servicioView.getServicio());
					reservacion.setStart(convertirFecha(convertirFecha
							.format(reservacionView.getFecha())
							+ " "
							+ convertirHora.format(reservacionView.getHora()
									.getTime())));
					reservacion.setEnd(convertirFecha(convertirFecha
							.format(reservacionView.getFecha())
							+ " "
							+ convertirHora.format(sumarHora.getTime())));
					reservacion.setBackgroundColor("#f56954");
					reservacion.setBorderColor("#f56954");

					calendario.add(reservacion);
				}
			}
		}

		return calendario;
	}
	
	public List<CalendarioPOJO> reservacionSerializer(
			List<ReservacionesPOJO> listaReservacionesView) {

		List<CalendarioPOJO> calendario = new ArrayList<CalendarioPOJO>();

		for (ReservacionesPOJO reservacionView : listaReservacionesView) {
			CalendarioPOJO reservacion = new CalendarioPOJO();

			SimpleDateFormat convertirHora = new SimpleDateFormat("HH:mm");
			SimpleDateFormat convertirFecha = new SimpleDateFormat("dd-MM-yyyy");

			Calendar sumarHora = Calendar.getInstance();
			sumarHora.setTime(reservacionView.getHora());
			sumarHora.add(Calendar.HOUR_OF_DAY, 1);
			
			reservacion.setTitle("Cancha");
			reservacion
					.setStart(convertirFecha(convertirFecha
							.format(reservacionView.getFecha())
							+ " "
							+ convertirHora.format(reservacionView.getHora()
									.getTime())));
			reservacion.setEnd(convertirFecha(convertirFecha
					.format(reservacionView.getFecha())
					+ " "
					+ convertirHora.format(sumarHora.getTime())));
			reservacion.setBackgroundColor("#f56954");
			reservacion.setBorderColor("#f56954");

			calendario.add(reservacion);
		}

		return calendario;
	}

	private DateTime convertirFecha(String fecha) {
		DateTimeFormatter convertirFechaHora = DateTimeFormat
				.forPattern("dd-MM-yyyy HH:mm");
		return convertirFechaHora.parseDateTime(fecha);

	}

	public ReservacionesPOJO saveReservacion(ReservacionesRequest reservacion,
			ReservacionesServiceInterface reservacionService, Usuario usuario,
			Servicio servicio) {
		
		
		Reservaciones reservacionEJB = new Reservaciones();
		reservacionEJB.setFecha(reservacion.getFecha());
		reservacionEJB.setHora(reservacion.getHora());
		reservacionEJB.setEstado(reservacion.getEstado());

		reservacionEJB.setServicio(servicio);
		reservacionEJB.setUsuario(usuario);
		
		if(reservacion.getAccion().equals("Aceptar")){
			reservacionEJB.setIdCalendario(reservacion.getIdCalendario());
		}

		ReservacionesPOJO reservacionPOJO = new ReservacionesPOJO();

		PojoUtils.pojoMappingUtility(reservacionPOJO,
				reservacionService.save(reservacionEJB));

		return reservacionPOJO;
	}

}
