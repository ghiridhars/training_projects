package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeException;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/addEmployee")
	public EmployeeDto addEmployee(@RequestBody EmployeeDto s) {
		return empService.addEmployee(s);
	}

	@GetMapping("/getAllEmployees")
	public List<EmployeeDto> getAllEmployees() {
		System.out.println("Getting all students");
		return empService.getAllEmployees();
	}

	@GetMapping("/getByDesignation/{desig}")
	public List<Employee> getEmployeeByDesignation(@PathVariable String desig) {
		System.out.println("Getting Employee by designation");
		return empService.getEmployeeByDesignation(desig);
	}

	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		System.out.println("Getting employee by id");
		Employee emp = null;
		try {
			emp = empService.getEmployeeById(id);
			return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
		} catch (EmployeeException e) {
			e.printStackTrace();
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateSalary/{id}")
	public ResponseEntity<?> updateSalaryById(@PathVariable int id, @RequestBody Employee emp) {
		System.out.println("updating employee salary by id");
		Employee res = null;
		try {
			res = empService.updateSalaryById(id, emp);
			return new ResponseEntity<Employee>(res, HttpStatus.ACCEPTED);
		} catch (EmployeeException e) {
			e.printStackTrace();
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}

	}

}
