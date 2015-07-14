package org.opi.sports.helpers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.opi.sports.pojo.ReservacionesPOJO;


/**
 * Fecha: 12-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *Sprint 01 Descripción:Esta clase sirve de apoyo a la clase de ReservacionesController
 *y contiene la lógica necesaria para serializar las reservaciones y poder mostrarlas en el front end
 *Esta clase se implementa como "Singleton" para asegurarnos que sea instanciada una sola vez.
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
	 *Este método serializa cada uno de los atributos de "Reservaciones" 
	 *para poder utilizarlos en el front end como un JSON
	 */
	public List<String> calendarioSerializer(
			List<ReservacionesPOJO> listaReservacionesView) {

		List<String> listaReservaciones = new ArrayList<String>();
		
		for (ReservacionesPOJO reservacionView : listaReservacionesView) {
			String reservaciones = "'{";

			Calendar startTime = Calendar.getInstance();
			Calendar endTime = Calendar.getInstance();

			startTime.setTime(reservacionView.getFecha());
			endTime.setTime(reservacionView.getFecha());

			endTime.add(Calendar.HOUR_OF_DAY, 1);

			System.out.println(startTime);
			System.out.println(endTime);

			reservaciones = "title:'" + "Cancha futbol #5" + "'," + "start:'"
					+ startTime + "'," + "end:'" + endTime + "',"
					+ "backgroundColor: '#f39c12'," + "borderColor: '#f39c12'}";
			listaReservaciones.add(reservaciones);
		}

		return listaReservaciones;
	}

}
