package com.mindtree.ratingsData;

import java.util.List;

public class UserRating {

	private List<Rating> ratings;
	private int userId;

	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRating(java.util.List<Rating> ratings, int userId) {
		super();
		this.ratings = ratings;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
