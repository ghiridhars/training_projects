package com.mindtree.webAppDemo2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.ModelMap;

import com.mindtree.webAppDemo2.entity.Employee;
import com.mindtree.webAppDemo2.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
		
	public Employee addEmployee(Employee emp) {
		empRepo.save(emp);
		return emp;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> li = new ArrayList<>();
		empRepo.findAll().forEach(li::add);
		return li;
	}
}
