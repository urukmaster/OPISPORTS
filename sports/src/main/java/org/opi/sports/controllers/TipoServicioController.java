package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.TipoServicioResponse;
import org.opi.sports.ejb.TipoServicio;
import org.opi.sports.pojo.TipoServicioPOJO;
import org.opi.sports.services.TipoServicioServiceInterface;
import org.opi.sports.utils.PojoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 20-07-2015
 * 
 * @author Luis Esteban López Ramírez
 *
 *         Sprint #4 Descripción: Se encarga de gestionar los tipos de permisos
 *         desde le front end, segun las peticiones por parte de la aplicación.
 */
@RestController
@RequestMapping(value = "rest/tipoServicio")
public class TipoServicioController {

	@Autowired
	TipoServicioServiceInterface tipoServicioService;

	/**
	 * Método que se encarga de solicitar todos los tipos de servicios
	 * existentes
	 * 
	 * @return TipoServicioResponse
	 */
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public TipoServicioResponse getAll() {

		TipoServicioResponse tipoServicioResponse = new TipoServicioResponse();

		try {

			List<TipoServicio> tipoServicioList = tipoServicioService
					.getAllTipoServicio();
			List<TipoServicioPOJO> tipoServicioViewList = new ArrayList<TipoServicioPOJO>();

			for (TipoServicio tipoServicio : tipoServicioList) {
				TipoServicioPOJO tipoServicioView = new TipoServicioPOJO();
				PojoUtils.pojoMappingUtility(tipoServicioView, tipoServicio);
				tipoServicioViewList.add(tipoServicioView);
			}

			tipoServicioResponse.setTipoServicio(tipoServicioViewList);
			tipoServicioResponse.setCode(200);
			tipoServicioResponse.setCodeMessage("Operación Exitosa");
		} catch (Exception exception) {
			tipoServicioResponse.setCode(404);
			tipoServicioResponse.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
					+ "Lamentamos el incoveniente, favor intentar mas tarde");
			tipoServicioResponse.setErrorMessage(exception.getMessage());
		}

		return tipoServicioResponse;
	}

}
