package org.opi.sports.repositories;

import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review,Integer>{
	/**
	 * Metodo encaragado de registrar el review
	 */
	public <S extends Review> S save(S review);
	
	public Review findOne(Integer idReview);
}
