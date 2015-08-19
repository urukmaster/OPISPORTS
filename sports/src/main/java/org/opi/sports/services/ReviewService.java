package org.opi.sports.services;

import java.util.List;

import org.opi.sports.ejb.CentroDistribucion;
import org.opi.sports.ejb.Review;
import org.opi.sports.ejb.Usuario;
import org.opi.sports.repositories.CentroDistribucionRepository;
import org.opi.sports.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService implements ReviewServiceInterface {

	@Autowired
	public ReviewRepository reviewRepository;

	@Transactional
	public <S extends Review> S save(S review) {
		try {
			return reviewRepository.save(review);
		} catch (Exception exception) {
			throw exception;
		}
	}

	@Transactional
	public Review findOne(Integer idReview) {
		try {
			return reviewRepository.findOne(idReview);
		} catch (Exception exception) {
			throw exception;
		}
	}

}
