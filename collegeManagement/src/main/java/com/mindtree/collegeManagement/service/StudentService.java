package com.mindtree.collegeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.collegeManagement.dto.StudentDto;
import com.mindtree.collegeManagement.entity.Student;
import com.mindtree.collegeManagement.exception.InvalidStudentException;


@Service
public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student getStudentById(int id) throws InvalidStudentException;
	
	Student addStudentById(Student s, int id) throws InvalidStudentException;
	
	StudentDto getStudentByName(int id);
}
