package com.example.demo.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentServiceImpl {
	
	@Autowired
	private StudentRepo studentRepo;

	List<Student> studentList = new ArrayList<>();

	public List<Student> getAllStudents() {
		List<Student> li= new ArrayList<>();
		studentRepo.findAll().forEach(li::add);
		return li;
	}
	
	public Student getStudentByName(int id) {
		studentList = getAllStudents();
		return studentList.stream().filter(x -> x.getId() == id).findFirst().get();
	}
	
	public void addStudent(Student s){
		studentRepo.save(s);
		System.out.println("Added");
	}
}
