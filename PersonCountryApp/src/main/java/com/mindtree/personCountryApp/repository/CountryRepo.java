package com.mindtree.personCountryApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.personCountryApp.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{

	@Query("select c from Country c where c.countryName=?1")
	public Optional<Country> findCountryByName(String name);
	
}
