package com.mindtree.collegeManagement.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.collegeManagement.dto.CollegeDto;
import com.mindtree.collegeManagement.dto.StudentDto;
import com.mindtree.collegeManagement.entity.College;
import com.mindtree.collegeManagement.entity.Student;
import com.mindtree.collegeManagement.exception.CollegeServiceException;
import com.mindtree.collegeManagement.exception.InvalidCollegeException;
import com.mindtree.collegeManagement.repository.CollegeRepo;
import com.mindtree.collegeManagement.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepo collegeRepo;
	
	ModelMapper model = new ModelMapper();
	
	public CollegeDto entityToDto(College e) {
		ModelMapper mapper = new ModelMapper();
		CollegeDto map = mapper.map(e, CollegeDto.class);
		return map;
	}
	
	public StudentDto entityToDto(Student e) {
		ModelMapper mapper = new ModelMapper();
		StudentDto map = mapper.map(e, StudentDto.class);
		return map;
	}

	public List<StudentDto> entityToDTo(List<Student> stu) {
		return stu.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}


	public College dtoToEntity(CollegeDto edto) {
		College emp = new College();
		ModelMapper mapper = new ModelMapper();
		College map = mapper.map(edto, College.class);
		return map;
	}

	public List<College> dtoToEntity(List<CollegeDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<CollegeDto> entityToDto(List<College> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}


	public List<CollegeDto> getAllDetails() throws CollegeServiceException {
		List<College> li = new ArrayList<>();
		try {
			collegeRepo.findAll().forEach(li::add);
			li.sort(new CollegeComparator());
		} catch (Exception e) {
			throw new CollegeServiceException("Service layer Exception when getting all details.",e);
		}
		return entityToDto(li);
	}

	public CollegeDto getCollegeById(int id) throws CollegeServiceException {
		College result = null;
		try {
			result = collegeRepo.findById(id).orElseThrow(() -> new InvalidCollegeException("College ID not found"));
		} catch (InvalidCollegeException e) {
			throw new CollegeServiceException("Service layer Exception when getting college details by id.",e);
		}
		return entityToDto(result);
	}

	public CollegeDto addCollege(CollegeDto s) throws CollegeServiceException {
		System.out.println("Added");
		try {
			collegeRepo.save(dtoToEntity(s));
		} catch (RuntimeException e) {
			throw new CollegeServiceException("Service layer Exception when adding details.",e);
		}
		return s;
	}

	public List<StudentDto> getStudentsById(int id) throws CollegeServiceException {
		College col=null;
		List<Student> li = null;
		try {
			col = collegeRepo.findById(id).orElseThrow(() ->  new InvalidCollegeException("College not found"));
			li = col.getStudents();
			li.sort(new StudentComparator());
		} catch (InvalidCollegeException e) {
			throw new CollegeServiceException("Service layer Exception when getting details by id.",e);
		}
		return entityToDTo(li);
	}

}
