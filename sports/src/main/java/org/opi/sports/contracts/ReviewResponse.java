package org.opi.sports.contracts;

import java.util.List;

import org.opi.sports.pojo.ReviewsPOJO;

public class ReviewResponse extends BaseResponse{
	
	private List<ReviewsPOJO> reviews;

	public List<ReviewsPOJO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewsPOJO> reviews) {
		this.reviews = reviews;
	}


}
