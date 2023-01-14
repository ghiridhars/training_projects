package com.mindtree.automobileApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.automobileApp.entity.Company;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer>{
	
	@Query("Select c from Company c where c.name=?1")
	public Optional<Company> findByName(String name);

}
