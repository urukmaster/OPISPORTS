package org.opi.sports.services;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Usuario;

public interface ReviewServiceInterface {
	
	public <S extends Review> S save(S review);
	
	public Review findOne(Integer idReview);
}
