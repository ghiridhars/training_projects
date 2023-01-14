package com.mindtree.personCountryApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.personCountryApp.entity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer>{

	@Query("select s from State s where s.stateName=?1")
	public Optional<State> findStateByName(String name);

	
}
