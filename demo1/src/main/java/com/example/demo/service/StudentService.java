package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

public interface StudentService {
	
	public List<Student> getAllStudents();
	
	public Student getStudentByName(int id);
	
	public void addStudent(Student s);
}
