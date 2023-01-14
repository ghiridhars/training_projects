package com.mindtree.movieApp.service.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.movieApp.dto.ActorDto;
import com.mindtree.movieApp.entity.Actor;
import com.mindtree.movieApp.entity.Movie;
import com.mindtree.movieApp.exception.MovieAppServiceException;
import com.mindtree.movieApp.exception.DaoException.InvalidMovieException;
import com.mindtree.movieApp.repository.ActorRepository;
import com.mindtree.movieApp.repository.MovieRepository;
import com.mindtree.movieApp.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	private ActorRepository actorRepo;
	
	@Autowired
	private MovieRepository movieRepo;

	ModelMapper mapper = new ModelMapper();

	public ActorDto entityToDto(Actor a) {
		return mapper.map(a, ActorDto.class);
	}
	
	public Actor dtoToEntity(ActorDto aDto) {
		return mapper.map(aDto, Actor.class);
	}

	public List<ActorDto> entityToDto(List<Actor> a) {
		return a.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public List<Actor> dtoToEntity(List<ActorDto> aDto) {
		return aDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	@Override
	public List<ActorDto> getActor(String name) throws MovieAppServiceException {
	
		List<Actor> a = null;
		
		try {
			Movie m = movieRepo.findByName(name)
					.orElseThrow(() -> new InvalidMovieException("Movie Not Found") );
			
			a = actorRepo.findAll();
			
			a = a.stream()
					.filter(x -> x.getMovie().getName().equalsIgnoreCase(name))
					.collect(Collectors.toList());
									
		} catch (InvalidMovieException e) {
			throw new MovieAppServiceException(e.getMessage(),e);
		}
		
		return entityToDto(a);
	}
	
	@Override
	public ActorDto addActor(ActorDto aDto, String name) throws MovieAppServiceException {
	
		Actor a = null;
		
		try {
			Movie m = movieRepo.findByName(name)
					.orElseThrow(() -> new InvalidMovieException("Movie Not Found") );
						
			a = dtoToEntity(aDto);
			
			a.setMovie(m);
			a=actorRepo.save(a);
		} catch (InvalidMovieException e) {
			throw new MovieAppServiceException(e.getMessage(),e);
		}
		
		return entityToDto(a);
	}

}
