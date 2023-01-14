package com.mindtree.movieApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.movieApp.dto.ActorDto;
import com.mindtree.movieApp.exception.MovieAppServiceException;
import com.mindtree.movieApp.service.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@PostMapping("/addActor/{name}")
	public ResponseEntity<?> addMovie(@RequestBody ActorDto aDto,@PathVariable String name) throws MovieAppServiceException{
	
		ActorDto a = null;		
		try {
			a = actorService.addActor(aDto, name);
			return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(),e);
		}
	}
	
	@RequestMapping("/getActor/{name}")
	public ResponseEntity<?> getActors(@PathVariable String name) throws MovieAppServiceException{
	
		List<ActorDto> a = null;		
		try {
			a = actorService.getActor(name);
			return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
		} catch (MovieAppServiceException e) {
			throw new MovieAppServiceException(e.getMessage(),e);
		}
	}

}
