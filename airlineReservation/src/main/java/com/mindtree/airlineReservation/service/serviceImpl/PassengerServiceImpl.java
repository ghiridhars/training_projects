package com.mindtree.airlineReservation.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.airlineReservation.entity.Flight;
import com.mindtree.airlineReservation.entity.Passenger;
import com.mindtree.airlineReservation.exception.InvalidPassengerException;
import com.mindtree.airlineReservation.repository.FlightRepo;
import com.mindtree.airlineReservation.repository.PassengerRepo;

@Service
public class PassengerServiceImpl {
	
	@Autowired
	private PassengerRepo passengerRepo;
	
	@Autowired
	private FlightRepo flightRepo;

	List<Passenger> PassengerList = new ArrayList<>();

	public List<Passenger> getAllPassengers() {
		List<Passenger> li= new ArrayList<>();
		passengerRepo.findAll().forEach(li::add);
		return li;
	}
	
	public Passenger getPassengerById(int id) throws InvalidPassengerException {
		Passenger result = passengerRepo.findById(id).orElse(null);
//		Flight c = FlightRepo.findById(result.getPassengerId()).orElse(null);
		if(result == null)
			throw new InvalidPassengerException("Passport ID not found");
		else
			return result;
	}
	
	public Passenger addPassengerById(Passenger s,int id) throws InvalidPassengerException{
		Flight per= flightRepo.findById(id).orElse(null);
		Passenger pass= null;
		if(per== null) {
			System.out.println("NULL");
			throw new InvalidPassengerException("Flight with id:"+id+"not found");
		}
		else {
			List<Passenger> li = new ArrayList<>();
			pass = passengerRepo.save(s);
			per.setPassengers(li);
			pass.setFlight(per);
			per = flightRepo.save(per);
		}
		System.out.println("Added Details");
		return pass;
	}
}
