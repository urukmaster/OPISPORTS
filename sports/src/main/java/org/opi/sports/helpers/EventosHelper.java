package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opi.sports.pojo.CalendarioPOJO;
import org.opi.sports.pojo.EventoPOJO;

/**
 * Fecha: 15-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 02 Descripción:Esta clase sirve de apoyo a la clase de
 *         EventosController y contiene la lógica necesaria para serializar los
 *         eventos y poder mostrarlas en el front end Esta clase se implementa
 *         como "Singleton" para asegurarnos que sea instanciada una sola vez.
 */

public class EventosHelper {

	private static EventosHelper instance;

	private EventosHelper() {
	}

	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new EventosHelper();
		}
	}

	public static EventosHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	/**
	 * Este método serializa cada uno de los atributos de "Eventos" para poder
	 * utilizarlos en el front end como un JSON
	 */
	public List<CalendarioPOJO> calendarioSerializer(
			List<EventoPOJO> listaEventosView) {

		List<CalendarioPOJO> listaEventos = new ArrayList<CalendarioPOJO>();

		for (EventoPOJO eventoView : listaEventosView) {
			CalendarioPOJO eventos = new CalendarioPOJO();

			SimpleDateFormat convertirHora = new SimpleDateFormat("HH:mm");
			SimpleDateFormat convertirFecha = new SimpleDateFormat("dd-MM-yyyy");

			Calendar sumarHora = Calendar.getInstance();
			sumarHora.setTime(eventoView.getHora());
			sumarHora.add(Calendar.HOUR_OF_DAY, 1);

			eventos.setTitle("Carrera");
			eventos.setStart(convertirFecha(convertirFecha.format(eventoView
					.getFecha())
					+ " "
					+ convertirHora.format(eventoView.getHora().getTime())));
			eventos.setEnd(convertirFecha(convertirFecha.format(eventoView
					.getFecha())
					+ " "
					+ convertirHora.format(sumarHora.getTime())));
			eventos.setBackgroundColor("#f56954");
			eventos.setBorderColor("#f56954");

			listaEventos.add(eventos);
		}

		return listaEventos;
	}

	private DateTime convertirFecha(String fecha) {
		DateTimeFormatter convertirFechaHora = DateTimeFormat
				.forPattern("dd-MM-yyyy HH:mm");
		return convertirFechaHora.parseDateTime(fecha);

	}

}