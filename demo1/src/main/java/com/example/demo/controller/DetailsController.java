package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StudentDetails;
import com.example.demo.service.DetailsService;

@RestController
@RequestMapping("/StudentDetails")
public class DetailsController {
	
	@Autowired
	private DetailsService detailsService;

	@RequestMapping("/getAllDetails")
	public List<StudentDetails> getAllDetails() {

		System.out.println("Getting all students' details");
		return detailsService.getAllDetails();
	}

	@GetMapping("/getDetails/{id}")
	public StudentDetails getStudentDetails(@PathVariable int id){
		
		System.out.println("Getting student by id");
		return detailsService.getStudentById(id);
	}
	
	@PostMapping("/addDetails")
	public void addDetails(@RequestBody StudentDetails s){
		detailsService.addStudentDetails(s);
	}


}
