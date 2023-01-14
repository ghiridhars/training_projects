package com.mindtree.collegeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.collegeManagement.entity.College;


@Repository
public interface CollegeRepo extends JpaRepository<College, Integer>{

}
