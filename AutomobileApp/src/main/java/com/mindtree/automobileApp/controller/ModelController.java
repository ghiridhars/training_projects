package com.mindtree.automobileApp.controller;

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

import com.mindtree.automobileApp.dto.ModelDto;
import com.mindtree.automobileApp.exception.AutomobileCompanyAppException;
import com.mindtree.automobileApp.exception.ServiceException;
import com.mindtree.automobileApp.service.ModelService;

@RestController
@RequestMapping("/model")
public class ModelController {

	@Autowired
	private ModelService modelService;

	@PostMapping("/addModel/{name}")
	public ResponseEntity<?> addModelByName(@RequestBody ModelDto mDto, @PathVariable String name) throws AutomobileCompanyAppException {

		ModelDto m = null;
		try {
			m = modelService.addModel(mDto, name);
			return new ResponseEntity(m, HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			throw new AutomobileCompanyAppException(e.getMessage(), e);
		}
	}
	
	@RequestMapping("/avgPrice/{name}")
	public ResponseEntity<?> getAveragePrice(@PathVariable String name) throws AutomobileCompanyAppException {

		Optional<Float> avg = null;
		try {
			avg = modelService.getAverage(name);
			return new ResponseEntity(avg, HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			throw new AutomobileCompanyAppException(e.getMessage(), e);
		}
	}
	
	@RequestMapping("/getModel/{name}/{color}")
	public ResponseEntity<?> getSortedModels(@PathVariable String name,@PathVariable String color) throws AutomobileCompanyAppException {

		List<ModelDto> avg = null;
		try {
			avg = modelService.getSortedModels(color, name);
			return new ResponseEntity(avg, HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			throw new AutomobileCompanyAppException(e.getMessage(), e);
		}
	}
}
