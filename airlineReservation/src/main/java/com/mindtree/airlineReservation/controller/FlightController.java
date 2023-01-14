package com.mindtree.airlineReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.airlineReservation.entity.Flight;
import com.mindtree.airlineReservation.exception.InvalidFlightException;
import com.mindtree.airlineReservation.service.serviceImpl.FlightServiceImpl;

@RestController
@RequestMapping("/Flight")
public class FlightController {

	@Autowired
	private FlightServiceImpl FlightService;
	
	@RequestMapping("/getAllDetails")
	public List<Flight> getAllDetails() {
		System.out.println("Getting all Flight details");
		return FlightService.getAllDetails();
	}
	
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<?> getFlightDetails(@PathVariable int id) throws InvalidFlightException {
		Flight pass=null;
		System.out.println("Getting Flight by id");
		try {
			pass = FlightService.getFlightById(id);
			return new ResponseEntity( pass,HttpStatus.ACCEPTED);
		} catch (InvalidFlightException e) {
			e.printStackTrace();
			throw new InvalidFlightException("Flight not found");
//			return new ResponseEntity(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addDetails")
	public Flight addDetails(@RequestBody Flight s) {
		Flight pass=null;
		try {
			pass= FlightService.addFlight(s);
		} catch (InvalidFlightException e) {
			e.printStackTrace();
		}
		return pass;
	}

}
