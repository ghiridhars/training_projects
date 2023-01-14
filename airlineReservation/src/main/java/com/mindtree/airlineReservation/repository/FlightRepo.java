package com.mindtree.airlineReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.airlineReservation.entity.Flight;


@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{

}
