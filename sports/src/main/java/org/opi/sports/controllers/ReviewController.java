package org.opi.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.opi.sports.contracts.CentroDistribucionRequest;
import org.opi.sports.contracts.CentroDistribucionResponse;
import org.opi.sports.contracts.ReviewRequest;
import org.opi.sports.contracts.ReviewResponse;
import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Review;
import org.opi.sports.helpers.CentroDistribucionHelper;
import org.opi.sports.helpers.ReviewHelper;
import org.opi.sports.pojo.CentroDistribucionPOJO;
import org.opi.sports.pojo.ReviewPOJO;
import org.opi.sports.services.CentroDistribucionServiceInterface;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ReviewServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/review")
public class ReviewController {

	@Autowired
	ReviewServiceInterface reviewService;

	@Autowired
	EstablecimientoDeportivoServiceInterface establecimientoDeportivoService;

	@Autowired
	UsuarioServiceInterface usuarioServices;

	/**
	 * Metodo encargado de registrar los centros de distribucion
	 * 
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ReviewResponse save(@RequestBody ReviewRequest reviewRequest) {

		ReviewResponse reviewResponse = new ReviewResponse();

		try {

			ReviewPOJO reviewPOJO = ReviewHelper.getInstance().saveReview(
					reviewRequest,
					reviewService,
					establecimientoDeportivoService.findOne(reviewRequest
							.getIdEstablecimientoDeportivo()),
					usuarioServices.findOne(reviewRequest.getIdUsuario()));

			reviewResponse.setCode(200);
			reviewResponse
					.setCodeMessage("El centro de distribucion se registro correctamente");
		} catch (Exception exception) {
			reviewResponse.setCode(404);
			reviewResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			reviewResponse.setErrorMessage(exception.getMessage());
		}
		return reviewResponse;
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ReviewResponse delete(@RequestBody ReviewRequest reviewRequest) {

		ReviewResponse reviewResponse = new ReviewResponse();
		try {
			Review review = reviewService.findOne(reviewRequest
					.getIdComentario());
			ReviewPOJO reviewpojo = ReviewHelper.getInstance().deleteReview(
					reviewService, review);

			reviewResponse.setCode(200);
			reviewResponse.setCodeMessage("El review se elimino correctamente");
		} catch (Exception exception) {
			reviewResponse.setCode(404);
			reviewResponse
					.setCodeMessage("En estos momentos el servidor no se encuentra disponible./n"
							+ "Lamentamos el incoveniente, favor intentar mas tarde");
			reviewResponse.setErrorMessage(exception.getMessage());
		}

		return reviewResponse;
	}

}
