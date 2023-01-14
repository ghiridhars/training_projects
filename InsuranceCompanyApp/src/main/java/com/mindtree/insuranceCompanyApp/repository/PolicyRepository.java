package com.mindtree.insuranceCompanyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.insuranceCompanyApp.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Integer>{
	


}
