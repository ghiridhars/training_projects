package com.mindtree.movieApp.service;


import java.util.List;

import com.mindtree.movieApp.dto.ActorDto;
import com.mindtree.movieApp.exception.MovieAppServiceException;

public interface ActorService {
	
	public ActorDto addActor(ActorDto aDto,String name) throws MovieAppServiceException;

	List<ActorDto> getActor(String name) throws MovieAppServiceException;


}
