package com.mindtree.collegeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.collegeManagement.dto.StudentDto;
import com.mindtree.collegeManagement.entity.Student;
import com.mindtree.collegeManagement.exception.CollegeApplicationException;
import com.mindtree.collegeManagement.exception.InvalidStudentException;
import com.mindtree.collegeManagement.exception.StudentServiceException;
import com.mindtree.collegeManagement.service.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@GetMapping("/getAllStudents")
	public ResponseEntity<?> getAllStudents() {
		System.out.println("Getting all students");
		List<Student> li = null;
		try {
			li =studentService.getAllStudents();
			return new ResponseEntity(li,HttpStatus.ACCEPTED);
		} catch (StudentServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("error when getting students",e);
		}
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<?> getStudent(@PathVariable int id) throws InvalidStudentException{
		Student stu=null;
		System.out.println("Getting Student by id");
		try {
			stu = studentService.getStudentById(id);
			return new ResponseEntity(stu,HttpStatus.ACCEPTED);
		} catch (StudentServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("Student not found");
//			return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addStudent/{id}")
	public ResponseEntity<?> addStudent(@RequestBody Student s,@PathVariable int id) throws InvalidStudentException{
		Student stu = null;
		try {
			stu = studentService.addStudentById(s,id);
			return new ResponseEntity(stu,HttpStatus.ACCEPTED);
		} catch (StudentServiceException e) {
			e.printStackTrace();
			throw new CollegeApplicationException("Student not added",e);
		}
	}
}
