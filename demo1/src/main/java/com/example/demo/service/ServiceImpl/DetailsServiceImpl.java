package com.example.demo.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentDetails;
import com.example.demo.repository.DetailsRepo;
import com.example.demo.repository.StudentRepo;

@Service
public class DetailsServiceImpl {
	
	@Autowired
	private DetailsRepo detailsRepo;
	
	@Autowired
	private StudentRepo studentRepo;

	List<StudentDetails> detailsList = new ArrayList<>();

	public List<StudentDetails> getAllDetails() {
		List<StudentDetails> li= new ArrayList<>();
		detailsRepo.findAll()
		.forEach(li::add);
		return li;
	}
	
	public StudentDetails getStudentById(int id) {
		detailsList=getAllDetails();
		return detailsList.stream().filter(x -> x.getPersonalId() == id).findFirst().get();
	}
	
	public StudentDetails addStudentDetails(StudentDetails sd,int studentId){
		Student stu = studentRepo.findById(studentId).orElse(null);
		StudentDetails stuDetail = null;
		if(stu == null) {
//			throw new InvalidStudentException("Student with id:"+studentId+"not found");
		}
		else {
			sd.setStudent(stu);
			stuDetail = detailsRepo.save(sd);
			stu.setDetails(stuDetail);
			stu = studentRepo.save(stu);
		}
		System.out.println("Added Details");
		return stuDetail;
	}
}
