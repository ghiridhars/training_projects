package com.mindtree.airlineReservation.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.airlineReservation.entity.Flight;
import com.mindtree.airlineReservation.exception.InvalidFlightException;
import com.mindtree.airlineReservation.repository.FlightRepo;
import com.mindtree.airlineReservation.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepo flightRepo;

	public List<Flight> getAllDetails() {
		List<Flight> li = new ArrayList<>();
		flightRepo.findAll().forEach(li::add);
		return li;
	}

	public Flight getFlightById(int id) throws InvalidFlightException {
		Flight result = flightRepo.findById(id).orElse(null);
		if (result == null)
			throw new InvalidFlightException("Flight ID not found");
		else
			return result;
	}

	public Flight addFlight(Flight s) throws InvalidFlightException {
		System.out.println("Added");
		return flightRepo.save(s);
	}

}
