package com.mindtree.CollegeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.CollegeApp.dto.CollegeDto;
import com.mindtree.CollegeApp.entity.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Integer>{

}
