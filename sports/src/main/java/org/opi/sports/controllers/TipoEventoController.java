package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.TipoEventoRequest;
import org.opi.sports.contracts.TipoEventoResponse;
import org.opi.sports.ejb.TipoEvento;
import org.opi.sports.helpers.TipoEventoHelper;
import org.opi.sports.pojo.TipoEventoPOJO;
import org.opi.sports.services.TipoEventoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 04-08-2015
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *         Sprint #4 Descripción: Se encarga de gestionar los tipos de eventos
 *         desde el front end, segun las peticiones por parte de la aplicación.
 */
@RestController
@RequestMapping(value = "rest/tipoEvento")
public class TipoEventoController {

	@Autowired
	TipoEventoServiceInterface tipoEventoService;

	/**
	 * Este método se encarga de guardar las tipos de eventos
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public TipoEventoResponse save(
			@RequestBody TipoEventoRequest tipoEventoRequest) {

		// Tipo Evento Response
		TipoEventoResponse tipoEventoResponse = new TipoEventoResponse();

		try {
			// Tipo Evento POJO
			TipoEventoPOJO tipoEventoView = TipoEventoHelper.getInstance()
					.saveTipoEvento(tipoEventoRequest, tipoEventoService);

			if (tipoEventoService.exists(tipoEventoView.getIdTipoEvento())) {
				tipoEventoResponse.setCode(200);
				tipoEventoResponse
						.setCodeMessage("El tipo de evento se registro correctamente");
			} else {
				tipoEventoResponse.setCode(401);
				tipoEventoResponse
						.setCodeMessage("El tipo de evento no se registro");
			}

			// Inicializacion de los tipos de eventos
			List<TipoEvento> tipoEventoList = tipoEventoService
					.getAllTipoEvento();

			// Lista de EstablecimientoDeportivoPOJO
			List<TipoEventoPOJO> tipoEventoViewList = new ArrayList<TipoEventoPOJO>();

			for (TipoEvento tipoEvento : tipoEventoList) {
				tipoEventoViewList.add(TipoEventoHelper.getInstance()
						.convertirTipoEvento(tipoEvento));
			}

			tipoEventoResponse.setTiposEventos(tipoEventoViewList);

			tipoEventoResponse.setCode(200);
			tipoEventoResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			tipoEventoResponse.setCode(404);
			tipoEventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			tipoEventoResponse.setErrorMessage(exception.getMessage());
		}

		return tipoEventoResponse;

	}

	/**
	 * Este método se encarga de actualizar los tipos de eventos
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public TipoEventoResponse update(
			@RequestBody TipoEventoRequest tipoEventoRequest) {

		// Tipo Evento Response
		TipoEventoResponse tipoEventoResponse = new TipoEventoResponse();
		try {
			// Tipo Evento POJO
			TipoEventoPOJO tipoEventoView = TipoEventoHelper.getInstance()
					.updateTipoEvento(tipoEventoRequest, tipoEventoService);

			if (tipoEventoService.exists(tipoEventoView.getIdTipoEvento())) {
				tipoEventoResponse.setCode(200);
				tipoEventoResponse
						.setCodeMessage("El tipo de evento se actualizo correctamente");
			} else {
				tipoEventoResponse.setCode(401);
				tipoEventoResponse
						.setCodeMessage("El tipo de evento no se actualizo");
			}

			// Inicializacion de los tipos de eventos
			List<TipoEvento> tipoEventoList = tipoEventoService
					.getAllTipoEvento();

			// Lista de EstablecimientoDeportivoPOJO
			List<TipoEventoPOJO> tipoEventoViewList = new ArrayList<TipoEventoPOJO>();

			for (TipoEvento tipoEvento : tipoEventoList) {
				tipoEventoViewList.add(TipoEventoHelper.getInstance()
						.convertirTipoEvento(tipoEvento));
			}

			tipoEventoResponse.setTiposEventos(tipoEventoViewList);

			tipoEventoResponse.setCode(200);
			tipoEventoResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			tipoEventoResponse.setCode(404);
			tipoEventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			tipoEventoResponse.setErrorMessage(exception.getMessage());
		}

		return tipoEventoResponse;

	}

	/**
	 * Este método se encarga de eliminar los tipos de eventos
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public TipoEventoResponse delete(
			@RequestBody TipoEventoRequest tipoEventoRequest) {

		// Tipo Evento Response
		TipoEventoResponse tipoEventoResponse = new TipoEventoResponse();
		try {
			// Tipo Evento POJO
			TipoEventoPOJO tipoEventoView = TipoEventoHelper.getInstance()
					.deleteTipoEvento(tipoEventoRequest, tipoEventoService);

			if (tipoEventoService.exists(tipoEventoView.getIdTipoEvento())) {
				tipoEventoResponse.setCode(200);
				tipoEventoResponse
						.setCodeMessage("El tipo de evento se elimino correctamente");
			} else {
				tipoEventoResponse.setCode(401);
				tipoEventoResponse
						.setCodeMessage("El tipo de evento no se elimino");
			}

			// Inicializacion de los tipos de eventos
			List<TipoEvento> tipoEventoList = tipoEventoService
					.getAllTipoEvento();

			// Lista de EstablecimientoDeportivoPOJO
			List<TipoEventoPOJO> tipoEventoViewList = new ArrayList<TipoEventoPOJO>();

			for (TipoEvento tipoEvento : tipoEventoList) {
				tipoEventoViewList.add(TipoEventoHelper.getInstance()
						.convertirTipoEvento(tipoEvento));
			}

			tipoEventoResponse.setTiposEventos(tipoEventoViewList);

			tipoEventoResponse.setCode(200);
			tipoEventoResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			tipoEventoResponse.setCode(404);
			tipoEventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			tipoEventoResponse.setErrorMessage(exception.getMessage());
		}

		return tipoEventoResponse;

	}

	/**
	 * Metodo encargado de solicitar todos los tipos de eventos
	 * 
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public TipoEventoResponse getAll() {

		// Variable de tipo EstablecimientoDeportivoResponse
		TipoEventoResponse tipoEventoResponse = new TipoEventoResponse();
		try {

			// Lista de tipo EstablecimientoDeportivo
			List<TipoEvento> tipoEventoList = tipoEventoService
					.getAllTipoEvento();
			// Lista de EstablecimientoDeportivoPOJO
			List<TipoEventoPOJO> tipoEventoViewList = new ArrayList<TipoEventoPOJO>();

			for (TipoEvento tipoEvento : tipoEventoList) {
				tipoEventoViewList.add(TipoEventoHelper.getInstance()
						.convertirTipoEvento(tipoEvento));
			}

			tipoEventoResponse.setTiposEventos(tipoEventoViewList);
			tipoEventoResponse.setCode(200);
			tipoEventoResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			tipoEventoResponse.setCode(404);
			tipoEventoResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			tipoEventoResponse.setErrorMessage(exception.getMessage());
		}

		return tipoEventoResponse;
	}
}
