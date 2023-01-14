package com.mindtree.airlineReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.airlineReservation.entity.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer>{
	

}
