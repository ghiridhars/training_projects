package com.mindtree.ajaxExample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ajaxExample.entity.Employee;
import com.mindtree.ajaxExample.repository.EmployeeRepo;

@Service("employeeService")
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepo empRepo;

	public List<Employee> getAllEmployees() {
		List<Employee> li = new ArrayList<>();
		empRepo.findAll().forEach(li::add);
		return li;
	}

	public List<Employee> getEmployeeByDesignation(String desig) {
		return empRepo.getEmployeeByDesignation(desig);
	}

	public Employee getEmployeeById(int id) {
		Employee result = empRepo.findById(id).orElse(null);
		return result;
	}

}
