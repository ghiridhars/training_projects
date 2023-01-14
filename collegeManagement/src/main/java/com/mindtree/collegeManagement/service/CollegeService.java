package com.mindtree.collegeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.collegeManagement.dto.CollegeDto;
import com.mindtree.collegeManagement.entity.College;
import com.mindtree.collegeManagement.exception.CollegeServiceException;
import com.mindtree.collegeManagement.exception.InvalidCollegeException;

@Service
public interface CollegeService{
	
	List<CollegeDto> getAllDetails()throws CollegeServiceException;
	
	CollegeDto getCollegeById(int id) throws CollegeServiceException;
	
	CollegeDto addCollege(CollegeDto s) throws CollegeServiceException;
}

