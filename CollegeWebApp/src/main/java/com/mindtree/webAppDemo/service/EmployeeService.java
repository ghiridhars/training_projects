package com.mindtree.webAppDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ui.ModelMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.webAppDemo.dto.EmployeeDto;
import com.mindtree.webAppDemo.entity.Employee;
import com.mindtree.webAppDemo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	ModelMapper mapper = new ModelMapper();

	public EmployeeDto entityToDto(Employee e) {
		ModelMapper mapper = new ModelMapper();
		EmployeeDto map = mapper.map(e, EmployeeDto.class);
		return map;
	}

	public Employee dtoToEntity(EmployeeDto edto) {
		Employee emp = new Employee();
		ModelMapper mapper = new ModelMapper();
		Employee map = mapper.map(edto, Employee.class);
		return map;
	}

	public List<Employee> dtoToEntity(List<EmployeeDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<EmployeeDto> entityToDto(List<Employee> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public EmployeeDto addEmployee(EmployeeDto eDto) {
		empRepo.save(dtoToEntity(eDto));
		return eDto;
	}

	public List<EmployeeDto> getAllEmployees() {
		List<Employee> li = new ArrayList<>();
		empRepo.findAll().forEach(li::add);
		return entityToDto(li);
	}
}
