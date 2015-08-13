package org.opi.sports.helpers;

import org.opi.sports.contracts.CentroDistribucionRequest;
import org.opi.sports.contracts.ReviewRequest;
import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.EstablecimientoDeportivo;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.pojo.CentroDistribucionPOJO;
import org.opi.sports.pojo.ReviewPOJO;
import org.opi.sports.services.CentroDistribucionServiceInterface;
import org.opi.sports.services.ReviewServiceInterface;
import org.opi.sports.utils.PojoUtils;

public class ReviewHelper {
	
	private static ReviewHelper instance;
	
	private ReviewServiceInterface reviewService;
	
	private ReviewHelper(){
	}
	
	private synchronized static void createInstance() {
		if (instance == null) {
			instance = new ReviewHelper();
		}
	}
	
	public static ReviewHelper getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	
	public ReviewPOJO saveReview(ReviewRequest reviewRequest,
			ReviewServiceInterface reviewService,EstablecimientoDeportivo establecimiento,Usuario usuario) {

		Review reviewEJB = new Review();
		reviewEJB.setReview(reviewRequest.getReview());
		reviewEJB.setEstablecimientoDeportivo(establecimiento);
		reviewEJB.setUsuario(usuario); 
		reviewEJB.setActive((byte)1);
		
		ReviewPOJO reviewPOJO = new ReviewPOJO();
		
		PojoUtils.pojoMappingUtility(reviewPOJO,
				reviewService.save(reviewEJB));
		return reviewPOJO;
	}
	
	public ReviewPOJO deleteReview(ReviewServiceInterface reviewService, Review reviewSet) {		
		reviewSet.setActive((byte)0);
		ReviewPOJO reviewPOJO = new ReviewPOJO();
		PojoUtils.pojoMappingUtility(reviewPOJO,
				reviewService.save(reviewSet));
		return reviewPOJO;
	}
	
}
