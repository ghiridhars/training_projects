package com.mindtree.movieCatalog;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.movieCatalog.entity.Catalog;
import com.mindtree.movieCatalog.entity.Movie;
import com.mindtree.movieCatalog.entity.Rating;
import com.mindtree.movieCatalog.entity.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {	
		
	@Autowired
	private RestTemplate restTemplate;

	
	@RequestMapping("/{id}")
	public List<Catalog> getCatalog(@PathVariable("id") String id){
							
//		WebClient.Builder builder = new WebClient.builder();
		
		System.out.println(id);
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+id,UserRating.class);
		
		System.out.println(ratings);
		
		List<Rating> ratingsList = ratings.getRatings();
		
		return ratingsList.stream().map(rating-> {
			Movie movie =restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movie.class);
			return new Catalog(movie.getName(),"Movie",rating.getRating());
			}).collect(Collectors.toList());		
	}

}
