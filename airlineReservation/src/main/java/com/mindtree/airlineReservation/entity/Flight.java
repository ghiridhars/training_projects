package com.mindtree.airlineReservation.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FlightId;
	private String FlightName;
	private String source;
	private String destination;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Flight")
	private List<Passenger> passengers;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFlightName() {
		return FlightName;
	}

	public void setFlightName(String FlightName) {
		this.FlightName = FlightName;
	}

	public int getFlightId() {
		return FlightId;
	}

	public void setFlightId(int FlightId) {
		this.FlightId = FlightId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}
