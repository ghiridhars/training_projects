package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getAllStudent")
	public List<Student> getAllStudents() {

		System.out.println("Getting all students");
		return studentService.getAllStudents();
	}

	@RequestMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable int id){
		
		System.out.println("Getting student by id");
		return studentService.getStudentByName(id);
	}
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student s){
		studentService.addStudent(s);
	}

}
