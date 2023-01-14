package com.mindtree.insuranceCompanyApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.insuranceCompanyApp.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{
	
	@Query("select c from Company c where c.name=?1")
	public Optional<Company> findByName(String name);

}
