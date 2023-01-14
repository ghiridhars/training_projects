package com.mindtree.airlineReservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.airlineReservation.entity.Flight;
import com.mindtree.airlineReservation.exception.InvalidFlightException;


@Service
public interface FlightService{
	
	public List<Flight> getAllDetails();
	
	public Flight getFlightById(int id) throws InvalidFlightException;
	
	public Flight addFlight(Flight s) throws InvalidFlightException;
}

