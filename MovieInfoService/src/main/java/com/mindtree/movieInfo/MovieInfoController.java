package com.mindtree.movieInfo;

import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movie")
public class MovieInfoController {
	
	@RequestMapping("/{id}")
	public Movie getMovieInfo(@PathVariable("id") String id) {
		return (new Movie(id,"Shutter Island"));
	}

}
