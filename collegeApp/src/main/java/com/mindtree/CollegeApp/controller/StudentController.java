package com.mindtree.CollegeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CollegeApp.dto.CollegeDto;
import com.mindtree.CollegeApp.dto.StudentDto;
import com.mindtree.CollegeApp.exception.CollegeApplicationException;
import com.mindtree.CollegeApp.exception.InvalidStudentException;
import com.mindtree.CollegeApp.exception.StudentServiceException;
import com.mindtree.CollegeApp.service.CollegeServiceImpl;
import com.mindtree.CollegeApp.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private CollegeServiceImpl collegeService;

	@RequestMapping(method = RequestMethod.GET, value = "/addStudent")
	public String addStudent(Model m) {
		m.addAttribute("collegeList", collegeService.getAllDetails());
		StudentDto s = new StudentDto();
		m.addAttribute("student",s);
		return "addStudent";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showStudent")
	public String showStudent(@Valid @ModelAttribute("student") StudentDto sDto, BindingResult br, Model m) {

		try {
			if (!br.hasErrors()) {
				StudentDto stu = studentService.addStudentById(sDto, sDto.getCollegeId());
				System.out.println(sDto);
				return "redirect:getStudents";

			} else {
//				m.addAttribute("errors", br.getFieldError().getDefaultMessage());
				return "addStudent";
			}
		} catch (StudentServiceException e) {
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editStudent/{studentId}")
	public String editStudent(@PathVariable("studentId") int studentId, Model m) {
		StudentDto s = studentService.getStudentById(studentId);
		System.out.println(s);
		m.addAttribute("collegeList", collegeService.getAllDetails());
		m.addAttribute("student", s);
		return "editStudent";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getStudents")
	public String getAllStudents(Model m) {
		System.out.println("Getting all students");
		m.addAttribute("collegeList", collegeService.getAllDetails());
		return "getStudent";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getStudent/{studentId}")
	public List<StudentDto> getStudentByCollege(@PathVariable("studentId") int studentId, Model m) {
		List<StudentDto> s = studentService.getStudentsById(studentId);
		System.out.println(s);
		return s;
	}
}
