package com.mindtree.collegeManagement.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.collegeManagement.dto.StudentDto;
import com.mindtree.collegeManagement.entity.College;
import com.mindtree.collegeManagement.entity.Student;
import com.mindtree.collegeManagement.exception.InvalidStudentException;
import com.mindtree.collegeManagement.repository.CollegeRepo;
import com.mindtree.collegeManagement.repository.StudentRepo;
import com.mindtree.collegeManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CollegeRepo collegeRepo;

	ModelMapper model = new ModelMapper();
	
	List<Student> studentList = new ArrayList<>();

	public List<Student> getAllStudents() {
		List<Student> li= new ArrayList<>();
		studentRepo.findAll().forEach(li::add);
		return li;
	}
	
	public Student getStudentById(int id) throws InvalidStudentException {
		Student result = studentRepo.findById(id).orElse(null);
		if(result == null)
			throw new InvalidStudentException("Passport ID not found");
		else
			return result;
	}
	
	public Student addStudentById(Student s, int id) throws InvalidStudentException{
		College per= collegeRepo.findById(id).orElse(null);
		Student pass= null;
		if(per== null) {
			System.out.println("NULL");
			throw new InvalidStudentException("College with id:"+id+"not found");
		}
		else {
			List<Student> li = new ArrayList<>();
			pass = studentRepo.save(s);
			per.setStudents(li);
			pass.setCollege(per);
			per = collegeRepo.save(per);
		}
		System.out.println("Added Details");
		return pass;
	}

	@Override
	public StudentDto getStudentByName(int id) {
		return null;
	}
}
