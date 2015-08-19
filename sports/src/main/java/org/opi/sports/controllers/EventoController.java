package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.id.uuid.Helper;
import org.opi.sports.contracts.EstablecimientoDeportivoResponse;
import org.opi.sports.contracts.EventoRequest;
import org.opi.sports.contracts.EventoResponse;
import org.opi.sports.contracts.TorneoRequest;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Evento;
import org.opi.sports.helpers.EstablecimientoDeportivoHelper;
import org.opi.sports.helpers.EventosHelper;
import org.opi.sports.pojo.DistritoPOJO;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;
import org.opi.sports.pojo.EventoPOJO;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.EventoServiceInterface;
import org.opi.sports.services.ReservacionesServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 14-07-2015 version 1.0
 * 
 * @author Mauricio Fernández Mora.
 *
 *         Sprint 02 Descripción:Esta clase es la que contendrá cada uno de los
 *         servicios que serán necesarios para procesar la información de los
 *         eventos deportivos de la aplicación
 */

@RestController
@RequestMapping(value = "rest/evento")
public class EventoController {

	@Autowired
	EventoServiceInterface eventoServices;

	@Autowired
	ReservacionesServiceInterface reservacionesService;

	/**
	 * Este método obtiene cada una de las instancias de eventos deportivos
	 * registrados en la base de datos
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public EventoResponse getAll() {

		EventoResponse eventoResponse = new EventoResponse();

		try {

			List<Evento> eventoList = eventoServices.getAllEventos();
			List<EventoPOJO> eventoViewList = new ArrayList<EventoPOJO>();

			for (Evento evento : eventoList) {

				if (evento.getActive() == 1) {
					eventoViewList.add(EventosHelper.getInstance()
							.convertirEvento(evento));
				}
			}

			eventoResponse.setEventos(eventoViewList);
			eventoResponse.setJSONCalendar(EventosHelper.getInstance()
					.calendarioSerializer(eventoViewList));
			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("Operacion exitosa");
		} catch (Exception exception) {
			eventoResponse.setCode(404);
			eventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			eventoResponse.setErrorMessage(exception.getMessage());
		}

		return eventoResponse;

	}

	/**
	 * Este método obtiene un evento deportivo registrado en la base de datos
	 * por medio de su id
	 */
	@RequestMapping(value = "getEvento", method = RequestMethod.POST)
	public EventoResponse getEvento(@RequestBody int idEvento) {

		EventoResponse eventoResponse = new EventoResponse();
		try {

			Evento evento = eventoServices.findOne(idEvento);

			eventoResponse.setEvento(EventosHelper.getInstance()
					.convertirEvento(evento));

			eventoResponse.setFecha();
			eventoResponse.setHora();

			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("Operacion exitosa");
		} catch (Exception exception) {
			eventoResponse.setCode(404);
			eventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			eventoResponse.setErrorMessage(exception.getMessage());
		}

		return eventoResponse;

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@Transactional
	public EventoResponse save(@RequestBody EventoRequest eventoRequest) {

		EventoResponse eventoResponse = new EventoResponse();

		try {
			EventoPOJO evento = EventosHelper.getInstance().save(eventoRequest,
					eventoServices);

			eventoResponse.setEvento(evento);

			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("Operacion exitosa");
		} catch (Exception exception) {
			eventoResponse.setCode(404);
			eventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			eventoResponse.setErrorMessage(exception.getMessage());
		}
		return eventoResponse;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public EventoResponse delete(@RequestBody int idEvento) {

		EventoResponse eventoResponse = new EventoResponse();
		Evento evento = eventoServices.findOne(idEvento);
		EventoPOJO eventoPOJO = new EventoPOJO();

		try {
			evento.setActive((byte) 0);

			eventoServices.save(evento);

			eventoResponse.setCode(200);
			eventoResponse.setCodeMessage("Operacion exitosa");
		} catch (Exception exception) {
			eventoResponse.setCode(404);
			eventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			eventoResponse.setErrorMessage(exception.getMessage());
		} finally {
			PojoUtils.pojoMappingUtility(eventoPOJO, evento);
			eventoResponse.setEvento(eventoPOJO);
		}
		
		return eventoResponse;
	}

}
