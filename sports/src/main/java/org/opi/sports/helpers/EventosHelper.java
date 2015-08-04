package org.opi.sports.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.opi.sports.contracts.EventoRequest;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Evento;
import org.opi.sports.pojo.EventoCalendarioPOJO;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.utils.PojoUtils;

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
	public List<EventoCalendarioPOJO> calendarioSerializer(
			List<EventoPOJO> listaEventosView) {

		List<EventoCalendarioPOJO> listaEventos = new ArrayList<EventoCalendarioPOJO>();

		for (EventoPOJO eventoView : listaEventosView) {
			EventoCalendarioPOJO eventos = new EventoCalendarioPOJO();

			SimpleDateFormat convertirHora = new SimpleDateFormat("HH:mm");
			SimpleDateFormat convertirFecha = new SimpleDateFormat("dd-MM-yyyy");

			Calendar sumarHora = Calendar.getInstance();
			sumarHora.setTime(eventoView.getHora());
			sumarHora.add(Calendar.HOUR_OF_DAY, 1);

			eventos.setTitle(eventoView.getNombre());
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

			eventos.setIdEvento(eventoView.getIdEvento());

			listaEventos.add(eventos);
		}

		return listaEventos;
	}
	/**
	 * Método que se encarga de gestionar las fechas
	 * @param fecha
	 * @return
	 */
	private DateTime convertirFecha(String fecha) {
		DateTimeFormatter convertirFechaHora = DateTimeFormat
				.forPattern("dd-MM-yyyy HH:mm");
		return convertirFechaHora.parseDateTime(fecha);

	}

	/**
	 * Método para guardar o modificar los eventos de un establcimiento deportivo
	 * @param eventoRequest
	 * @param eventoService
	 * @param establecimientoDeportivoService
	 * @return
	 */
	public EventoPOJO save(EventoRequest eventoRequest, EventoServiceInterface eventoService, EstablecimientoDeportivoServiceInterface establecimientoDeportivoService) {
		
		Evento evento = new Evento();
		
		EstablecimientoDeportivo establecimientoDeportivo = establecimientoDeportivoService.findOne(eventoRequest.getEstablecimiento());
		
		evento.setCupo(eventoRequest.getCupo());
		evento.setDireccion(eventoRequest.getDireccion());
		evento.setFecha(eventoRequest.getFecha());
		evento.setHora(eventoRequest.getHora());
		evento.setInformacion(eventoRequest.getInformacion());
		evento.setNombre(eventoRequest.getNombre());
		evento.setEstablecimientoDeportivo(establecimientoDeportivo);
		evento.setPrecio(eventoRequest.getPrecio());
		evento.setActive(eventoRequest.isActive());
		
		if(eventoRequest.getAccion().equals("Modificar")){
			evento.setIdEvento(eventoRequest.getIdEvento());
		}
		
		evento = eventoService.save(evento);
		
		EventoPOJO eventoPOJO = new EventoPOJO();
		
		PojoUtils.pojoMappingUtility(eventoPOJO, evento);
		
		return eventoPOJO;
		
	}
}