package com.mindtree.movieApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movieApp.dto.MovieDto;
import com.mindtree.movieApp.exception.MovieAppServiceException;
import com.mindtree.movieApp.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody MovieDto mDto) throws MovieAppServiceException {
		MovieDto m = null;

		try {
			m = movieService.addMovie(mDto);
			return new ResponseEntity<>(m, HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(), e);
		}
	}

	@RequestMapping("/getFilteredDetails")
	public ResponseEntity<?> getFilteredDetails() throws MovieAppServiceException {

		List<MovieDto> mList = null;

		try {
			mList = movieService.getFilteredDetails();
			return new ResponseEntity<>(mList, HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(), e);
		}
	}

	@RequestMapping("/getAverageBudget")
	public ResponseEntity<?> getAverageBudget() throws MovieAppServiceException {

		Optional<Float> avg= null;

		try {
			avg= movieService.getAverageBudget();
			return new ResponseEntity<>(avg, HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(), e);
		}

	}
	
	@RequestMapping("/getMovie/{name}")
	public ResponseEntity<?> getMoviesOfActor(@PathVariable String name) throws MovieAppServiceException {

		List<MovieDto> mList = null;

		try {
			mList= movieService.getMoviesOfActor(name);
			return new ResponseEntity<>(mList, HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(), e);
		}

	}

	@RequestMapping("/getAllDetails")
	public ResponseEntity<?> getAllDetails() throws MovieAppServiceException {

		List<MovieDto> mList = null;

		try {
			mList = movieService.getAllDetails();
			return new ResponseEntity<>(mList, HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(), e);
		}

	}

}
