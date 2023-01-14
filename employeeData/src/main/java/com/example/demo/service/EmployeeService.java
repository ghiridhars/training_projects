package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeException;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;
	
	private static ModelMapper mapper = new ModelMapper();
	
	public EmployeeDto entityToDto(Employee e) {
		ModelMapper mapper = new ModelMapper();
		EmployeeDto map= mapper.map(e,EmployeeDto.class);
		return map;
	}
	
	public Employee dtoToEntity(EmployeeDto edto) {
		Employee emp = new Employee();
		ModelMapper mapper = new ModelMapper();
		Employee map= mapper.map(edto,Employee.class);		
		return map;
	}
	
	public List<Employee> dtoToEntity(List<EmployeeDto> dto)
	{
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<EmployeeDto> entityToDto(List<Employee> emp)
	{
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public EmployeeDto addEmployee(EmployeeDto edto) {
		Employee e = dtoToEntity(edto);
		empRepo.save(e);
		System.out.println("Added");
		return edto;
	}
	
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> li = new ArrayList<>();
		empRepo.findAll().forEach(li::add);
		return entityToDto(li);
	}
	
	public List<Employee> getEmployeeByDesignation(String desig){
		return empRepo.getEmployeeByDesignation(desig);
	}
	
	

	public Employee getEmployeeById(int id) throws EmployeeException {
		Employee result = empRepo.findById(id).orElse(null);
		if (result == null)
			throw new EmployeeException("Employee not found");
		else
			return result;
	}


	public Employee updateSalaryById(int id, Employee emp) throws EmployeeException {
		Employee result = empRepo.findById(id).orElse(null);
		if (result == null)
			throw new EmployeeException("Employee not found");
		else {
			result.setSalary(emp.getSalary());
			empRepo.save(result);
		}
			return result;
	}
}
