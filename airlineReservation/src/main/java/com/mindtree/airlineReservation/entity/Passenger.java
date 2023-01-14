package com.mindtree.airlineReservation.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PassengerId;
	private String name;
	private String gender;
	private byte age;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnore
	private Flight Flight;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPassengerId() {
		return PassengerId;
	}

	public void setPassengerId(int PassengerId) {
		this.PassengerId = PassengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Flight getFlight() {
		return Flight;
	}

	public void setFlight(Flight Flight) {
		this.Flight = Flight;
	}

}
