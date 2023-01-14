package com.mindtree.personCountryApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.personCountryApp.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer>{

	@Query("select p from Person p where p.state.stateName=?1")
	public Optional<List<Person>> findPersonByState(String name);
	
}
