package org.opi.sports.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.opi.sports.config.OpiSportsApplication;
import org.opi.sports.contracts.ReviewRequest;
import org.opi.sports.contracts.ReviewResponse;
import org.opi.sports.ejb.Review;
import org.opi.sports.helpers.ReviewHelper;
import org.opi.sports.pojo.ReviewPOJO;
import org.opi.sports.services.EstablecimientoDeportivoServiceInterface;
import org.opi.sports.services.ReviewServiceInterface;
import org.opi.sports.services.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Fecha: 01-08-2015 version 1.0
 * 
 * @author Mauricio Araica
 *
 *Sprint 04 Descripción: prueba de reviewa o comentarios
 *
 */

//Se especifica con que correrá el JUNIT
@RunWith(SpringJUnit4ClassRunner.class)
//Se debe cargar la configuración del servidor
@SpringApplicationConfiguration(classes = OpiSportsApplication.class)
@WebAppConfiguration
public class ReviewTest {

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
	@Test
	public void save() {
		
		ReviewRequest reviewRequest = new ReviewRequest();
		
		reviewRequest.setActive((byte) 1);
		reviewRequest.setIdEstablecimientoDeportivo(1);
		reviewRequest.setIdUsuario(1);
		reviewRequest.setReview("Comentario");
		
		ReviewResponse reviewResponse = new ReviewResponse();
		
		ReviewPOJO reviewPOJO = ReviewHelper.getInstance().saveReview(reviewRequest,
					reviewService,establecimientoDeportivoService.findOne(reviewRequest.getIdEstablecimientoDeportivo())
					,usuarioServices.findOne(reviewRequest.getIdUsuario()));
		
		
		reviewResponse.setCode(200);
		reviewResponse.setCodeMessage("El centro de distribucion se registro correctamente");
		
		assertNotNull(reviewPOJO);
		
	}
	
	@Test
	public void delete() {
		
		ReviewRequest reviewRequest = new ReviewRequest();
		
		reviewRequest.setIdComentario(1);
		reviewRequest.setIdEstablecimientoDeportivo(1);
		reviewRequest.setIdUsuario(1);
		reviewRequest.setReview("Comentario");
		
		
		ReviewResponse reviewResponse = new ReviewResponse();
		Review review = reviewService.findOne(reviewRequest.getIdComentario());
		ReviewPOJO reviewpojo = ReviewHelper.getInstance().deleteReview(reviewService,review);
	
			reviewResponse.setCode(200);
			reviewResponse.setCodeMessage("El review se elimino correctamente");
			
			assertNotNull(reviewpojo);

	}

}
