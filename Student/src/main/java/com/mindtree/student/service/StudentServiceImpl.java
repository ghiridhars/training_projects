package com.mindtree.student.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.student.dto.StudentDto;
import com.mindtree.student.entity.Student;
import com.mindtree.student.exception.InvalidStudentException;
import com.mindtree.student.exception.StudentException;
import com.mindtree.student.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepo studentRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public StudentDto addStudent(StudentDto sDto) throws StudentException {

		Student s = null;
		try {
			StudentDto sd = getStudentByName(sDto.getName());
			if (sd != null)
				throw new InvalidStudentException("Student Already Present");
			s = mapper.map(sDto, Student.class);
			studentRepo.save(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage(), e);
		}
		return mapper.map(s, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto sDto) throws StudentException {

		Student s = null;
		try {
			s = mapper.map(sDto, Student.class);
			studentRepo.save(s);
		} catch (Exception e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage(), e);
		}
		return mapper.map(s, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudents() throws StudentException {

		List<StudentDto> list;
		try {
			List<Student> sList = studentRepo.findAll();

			list = sList.stream().map(x -> mapper.map(x, StudentDto.class)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new StudentException(e.getMessage(), e);
		}

		return list;

	}

	@Override
	public List<StudentDto> getStudentsByName(String name) throws StudentException {
		try {
			List<Student> sList = studentRepo.findByClass(name);
			return sList.stream().map(x -> mapper.map(x, StudentDto.class)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new StudentException(e.getMessage(), e);
		}
	}

	@Override
	public Set<String> getAllClasses() throws StudentException {
		Set<String> classes;
		try {
			List<StudentDto> sList = getAllStudents();
			classes = new HashSet<>(sList.stream().map(x -> x.getClassName()).collect(Collectors.toList()));
		} catch (StudentException e) {
			throw new StudentException(e.getMessage(), e);
		}
		return classes;
	}

	@Override
	public StudentDto getStudentByName(String sName) throws StudentException {

		StudentDto stu;
		try {
			List<StudentDto> sList = getAllStudents();
			stu = sList.stream().filter(x -> x.getName().equals(sName)).findFirst().orElse(null);
		} catch (StudentException e) {
			throw new StudentException(e.getMessage(), e);
		}
		return stu;
	}

	@Override
	public List<StudentDto> filerStudents(String className, List<String> subjects) throws StudentException {
		List<StudentDto> sList = null;
		try {
			sList = getAllStudents();
			sList = sList.stream().filter(x -> x.getClassName().equals(className)).collect(Collectors.toList());
			sList = sList.stream().filter(g -> g.getSubjects().containsAll(subjects)).collect(Collectors.toList());
			System.out.println(sList);
			

			if (sList.size() == 0)
				throw new InvalidStudentException("No students found");

			System.out.println(sList);
		} catch (StudentException e) {
			throw new StudentException(e.getMessage(), e);
		}
		return sList;
	}

	@Override
	public List<StudentDto> filterStudentsByGender(String className, String gender) throws StudentException {
		List<StudentDto> sList = null;
		try {
			if(className == null || gender ==null) {
				throw new InvalidStudentException("Invalid Entry");
			}
			sList = getAllStudents();
			sList = sList.stream().filter(x -> x.getClassName().equals(className)).collect(Collectors.toList());
			sList = sList.stream().filter(g -> g.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
			System.out.println(sList);
			

			if (sList.size() == 0)
				throw new InvalidStudentException("No students found");

			System.out.println(sList);
		} catch (StudentException e) {
			throw new StudentException(e.getMessage(), e);
		}
		return sList;
	}

}
