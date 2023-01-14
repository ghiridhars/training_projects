package com.mindtree.ratingsData;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingDataController {

	@RequestMapping("/{id}")
	public Rating getRating(@PathVariable("id") String id) {
		return (new Rating(id, 4));
	}

	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("121", 3), new Rating("123", 5));
		
		UserRating userRating = new UserRating();
		
		userRating.setRatings(ratings);
		
		return userRating;

	}

}
