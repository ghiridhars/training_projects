package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentDetails;

public interface DetailsService {
	
	public List<StudentDetails> getAllDetails();
	
	public StudentDetails getStudentById(int id);
	
	public void addStudentDetails(StudentDetails s);
}
