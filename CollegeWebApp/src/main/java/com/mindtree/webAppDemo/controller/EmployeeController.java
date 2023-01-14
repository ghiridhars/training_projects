package com.mindtree.webAppDemo.controller;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.webAppDemo.dto.EmployeeDto;
import com.mindtree.webAppDemo.entity.Employee;
import com.mindtree.webAppDemo.service.EmployeeService;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

//	@RequestMapping("/")
//    public String home(Model model) {
//        model.addAttribute("message", "Helooo");
//        return "emp";

	@RequestMapping(value = "/")
	public String index() {
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addEmployee")
	public String addEmployee(EmployeeDto e) {
		return "addEmployee";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showEmployee")
	public String showEmployee(@ModelAttribute("employee")@Valid EmployeeDto  eDto,BindingResult br,Model m) {
		
		if(!br.hasErrors()) {
			EmployeeDto emp = empService.addEmployee(eDto);
			m.addAttribute("name", emp.getName());
			m.addAttribute("salary", emp.getSalary());
			m.addAttribute("designation", emp.getDesignation());
			m.addAttribute("gender", emp.getSalary());
			m.addAttribute("hobbies",emp.getHobbies());
			
			return "redirect:getAllEmployees";

		}
		else {
			m.addAttribute("errors", br.getAllErrors());
			return "errors";
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllEmployees")
	public String getAllEmployees(Model m) {
		System.out.println("Getting all students");
		m.addAttribute("employeeList", empService.getAllEmployees());
		return "getEmployee";
	}
}
