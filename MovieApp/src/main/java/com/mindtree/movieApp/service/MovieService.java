package com.mindtree.movieApp.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.movieApp.dto.MovieDto;
import com.mindtree.movieApp.exception.MovieAppServiceException;

public interface MovieService {
	
	public MovieDto addMovie(MovieDto mDto) throws MovieAppServiceException;
	
	public List<MovieDto> getAllDetails() throws MovieAppServiceException;

	public List<MovieDto> getFilteredDetails() throws MovieAppServiceException;

	Optional<Float> getAverageBudget() throws MovieAppServiceException;

	public List<MovieDto> getMoviesOfActor(String name)throws MovieAppServiceException;
	

}
