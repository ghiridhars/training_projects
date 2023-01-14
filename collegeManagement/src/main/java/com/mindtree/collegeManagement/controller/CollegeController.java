package com.mindtree.collegeManagement.controller;

import com.mindtree.collegeManagement.dto.CollegeDto;
import com.mindtree.collegeManagement.dto.StudentDto;
import com.mindtree.collegeManagement.exception.CollegeApplicationException;
import com.mindtree.collegeManagement.exception.CollegeServiceException;
import com.mindtree.collegeManagement.service.serviceImpl.CollegeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/College")
public class CollegeController {

	@Autowired
	private CollegeServiceImpl collegeService;
	
	@RequestMapping("/getAllDetails")
	public ResponseEntity<?> getAllDetails() {
		List<CollegeDto> li= null;
		System.out.println("Getting all College details");
		try {
			li = collegeService.getAllDetails();
			return new ResponseEntity(li,HttpStatus.ACCEPTED);
			}
		catch (CollegeServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("Controller Layer not able to get all details",e);
		}
	}
	
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<?> getCollegeDetails(@PathVariable int id) {
		CollegeDto pass=null;
		System.out.println("Getting College by id");
		try {
			pass = collegeService.getCollegeById(id);
			return new ResponseEntity(pass,HttpStatus.ACCEPTED);
		} catch (CollegeServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("Controller Layer not able to get details",e);
//			return new ResponseEntity(e.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getStudentsByCollege/{id}")
	public ResponseEntity<?> getStudentDetailsById(@PathVariable int id) {
		List<StudentDto> li=null;
		System.out.println("Getting Student details by id");
		try {
			li = collegeService.getStudentsById(id);
			return new ResponseEntity(li,HttpStatus.ACCEPTED);
		} catch (CollegeServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("Controller Layer not able to get student details by id",e);
//			return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addDetails")
	public CollegeDto addDetails(@RequestBody CollegeDto s){
		CollegeDto pass=null;
		try {
			pass= collegeService.addCollege(s);
		} catch (CollegeServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("Controller Layer not able to add details",e);
		}
		return pass;
	}
}
