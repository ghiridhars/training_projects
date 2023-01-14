package com.mindtree.student.service;

import java.util.List;
import java.util.Set;

import com.mindtree.student.dto.StudentDto;
import com.mindtree.student.exception.StudentException;

public interface StudentService {
	
	public StudentDto addStudent(StudentDto s)throws StudentException;
	
	public List<StudentDto> getAllStudents()throws StudentException;
	
	public List<StudentDto> getStudentsByName(String g)throws StudentException;

	public Set<String> getAllClasses()throws StudentException;

	public StudentDto getStudentByName(String name)throws StudentException;

	public StudentDto updateStudent(StudentDto sDto) throws StudentException;

	public List<StudentDto> filerStudents(String className, List<String> subject) throws StudentException;

	public List<StudentDto> filterStudentsByGender(String className, String gender)throws StudentException;

}
