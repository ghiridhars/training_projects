package com.mindtree.student.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.student.dto.StudentDto;
import com.mindtree.student.exception.StudentAppException;
import com.mindtree.student.exception.StudentException;
import com.mindtree.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String getHome() {
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addStudent")
	public String addStudent() {
		return "addStudent";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveStudent")
	public String saveStudent(@ModelAttribute("student") StudentDto sDto, BindingResult br, Model m)
			throws StudentAppException {
		StudentDto s = null;
		try {
			s = studentService.addStudent(sDto);
			System.out.println(s);
			return "redirect:getAllData";
		} catch (StudentException e) {
			throw new StudentAppException(e.getMessage(), e);
		} catch (Exception e) {
			throw new StudentAppException(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updateStudent")
	public String updateStudent(@ModelAttribute("student") StudentDto sDto, BindingResult br, Model m)
			throws StudentAppException {
		StudentDto s = null;
		try {
			s = studentService.updateStudent(sDto);
			System.out.println(s);
			return "redirect:getAllData";
		} catch (StudentException e) {
			throw new StudentAppException(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllData")
	public String getAllStudents(Model m) throws StudentAppException {
		Set<String> slist = null;
		try {
			slist = studentService.getAllClasses();
			m.addAttribute("classList", slist);
			return "getStudent";
		} catch (StudentException e) {
			throw new StudentAppException(e.getMessage(), e);
		} catch (Exception e) {
			throw new StudentAppException(e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getFilterData")
	public String getFilterStudents(Model m) throws StudentAppException {
		return "getFilterData";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getFilterDataByGender")
	public String getFilterStudentsByGender(Model m) throws StudentAppException {
		return "getFilterDataByGender";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editStudent/{name}")
	public String editStudent(@PathVariable("name") String name, Model m) throws StudentAppException {
		StudentDto s = null;
		try {
			s = studentService.getStudentByName(name);
			System.out.println(s);
		} catch (StudentException e) {
			throw new StudentAppException(e.getMessage(), e);
		} catch (Exception e) {
			throw new StudentAppException(e.getMessage(), e);
		}
		m.addAttribute("student", s);
		return "editStudent";
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getStudent/{name}")
	public List<StudentDto> getStudentByClass(@PathVariable String name, Model m) throws StudentAppException {
		List<StudentDto> sList = null;
		try {
			sList = studentService.getStudentsByName(name);
		} catch (StudentException e) {
			throw new StudentAppException(e.getMessage(), e);
		}
		return sList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/error/{errorName}")
	public String error(@PathVariable String errorName) throws StudentAppException {
		System.out.println(errorName);
		throw new StudentAppException(errorName);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getStudentBy/{className}/{subjects}")
	public List<StudentDto> getStudentByClass(@PathVariable String className, @PathVariable List<String> subjects,
			Model m) throws StudentAppException {
		List<StudentDto> sList = null;
		sList = studentService.filerStudents(className, subjects);
		System.out.println(sList);
		return sList;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/getStudentByGender/{className}/{gender}")
	public List<StudentDto> getStudentByClass(@PathVariable String className, @PathVariable String gender,
			Model m) throws StudentAppException {
		List<StudentDto> sList = null;
		sList = studentService.filterStudentsByGender(className, gender);
		System.out.println(sList);
		return sList;
	}

}
