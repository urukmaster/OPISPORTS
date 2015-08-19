package org.opi.sports.controllers;

import javax.transaction.Transactional;

import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.contracts.UsuarioResponse;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.helpers.IniciarSesionHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.UsuarioRequest;
import org.opi.sports.contracts.UsuarioResponse;
import org.opi.sports.helpers.UsuarioHelper;
import org.opi.sports.pojo.UsuarioPOJO;
import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fecha: 26-07-2015 version 1.0
 * 
 * @author Mauricio Araica Hernández
 *
 *         Sprint 03 Descripción: Controlador rest del usuario
 *
 *
 *         Fecha: 23-07-2015
 * 
 * @author Juan Manuel Viales Chavarría
 *
 *         Sprint #4 Descripción: Se encarga de gestionar los usuarios desde el
 *         front end, segun las peticiones por parte de la aplicación.
 */

@RestController
@RequestMapping(value = "rest/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceInterface usuarioService;

	/**
	 * Metodo que obtiene la informacion para el perfil del usuario
	 * 
	 * @return usuarioresponse
	 */
	@RequestMapping(value = "perfilUsuario", method = RequestMethod.POST)
	@Transactional
	public UsuarioResponse perfilUsuario(
			@RequestBody UsuarioRequest usuarioRequest) {
		int idUsuario = usuarioRequest.getIdUsuario();
		UsuarioResponse usuarioresponse = new UsuarioResponse();

		try {
			Usuario usuario = usuarioService.findOne(idUsuario);
			if (usuarioService.exists(usuario.getIdUsuario())) {
				UsuarioPOJO usuariopojo = new UsuarioPOJO();
				usuariopojo = UsuarioHelper.getInstance()
						.perfilUsuario(usuario);
				usuarioresponse.setUsuario(usuariopojo);
				usuarioresponse.setCode(200);
				usuarioresponse.setCodeMessage("Conexión exitosa");
			}
		} catch (Exception sqlException) {
			usuarioresponse.setCode(404);
			usuarioresponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			usuarioresponse.setErrorMessage(sqlException.getMessage());
		}

		return usuarioresponse;
	}

	/**
	 * Este método se encarga de guardar los usuarios
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public UsuarioResponse save(@RequestBody UsuarioRequest usuarioRequest) {

		// Usuario Response
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		// UsuarioPOJO
		try {

			UsuarioPOJO usuarioView = UsuarioHelper.getInstance().saveUsuario(
					usuarioRequest, usuarioService);

			if (usuarioService.exists(usuarioView.getIdUsuario())) {
				List<UsuarioPOJO> usuarios = new ArrayList<UsuarioPOJO>();
				usuarios.add(usuarioView);
				usuarioResponse.setUsuarios(usuarios);
				usuarioResponse.setCode(200);
				usuarioResponse
						.setCodeMessage("El usuario se registro correctamente");
			} else {
				usuarioResponse.setCode(401);
				usuarioResponse.setCodeMessage("El usuario no se registro");
			}

		} catch (Exception sqlException) {
			usuarioResponse.setCode(404);
			usuarioResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			usuarioResponse.setErrorMessage(sqlException.getMessage());
		}
		return usuarioResponse;

	}

	/**
	 * Este método se encarga de actualizar los usuarios
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public UsuarioResponse update(@RequestBody UsuarioRequest usuarioRequest) {

		// Usuario Response
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		// UsuarioPOJO
		try {
			UsuarioPOJO usuarioView = UsuarioHelper.getInstance()
					.updateUsuario(usuarioRequest, usuarioService);

			if (usuarioService.exists(usuarioView.getIdUsuario())) {
				List<UsuarioPOJO> usuarios = new ArrayList<UsuarioPOJO>();
				usuarios.add(usuarioView);
				usuarioResponse.setUsuarios(usuarios);
				usuarioResponse.setCode(200);
				usuarioResponse
						.setCodeMessage("El usuario se actualizo correctamente");
			} else {
				usuarioResponse.setCode(401);
				usuarioResponse.setCodeMessage("El usuario no se actualizo");
			}
		} catch (Exception sqlException) {
			usuarioResponse.setCode(404);
			usuarioResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			usuarioResponse.setErrorMessage(sqlException.getMessage());
		}

		return usuarioResponse;
	}
}
