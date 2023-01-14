package com.mindtree.airlineReservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.airlineReservation.entity.Passenger;
import com.mindtree.airlineReservation.exception.AirlineException;
import com.mindtree.airlineReservation.exception.InvalidPassengerException;
import com.mindtree.airlineReservation.service.serviceImpl.PassengerServiceImpl;

@RestController
@RequestMapping("/Passenger")
public class PassengerController {

	@Autowired
	private PassengerServiceImpl passengerService;

	@RequestMapping("/getAllPassengers")
	public List<Passenger> getAllPassengers() {
		System.out.println("Getting all Passengers");
		return passengerService.getAllPassengers();
	}

	@RequestMapping("/getPassenger/{id}")
	public Passenger getPassenger(@PathVariable int id){
		Passenger per=null;
		System.out.println("Getting Passenger by id");
		try {
			per = passengerService.getPassengerById(id);
		} catch (InvalidPassengerException e) {
			e.printStackTrace();
		}
		return per;
	}
	
	@PostMapping("/addPassenger/{id}")
	public Passenger addPassenger(@RequestBody Passenger s,@PathVariable int id){
		Passenger stu = null;
		try {
			stu = passengerService.addPassengerById(s,id);
		} catch (AirlineException e) {
			e.printStackTrace();
		}
		return stu;
	}

}
