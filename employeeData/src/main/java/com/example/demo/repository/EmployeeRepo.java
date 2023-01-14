package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository("empRepo")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT emp FROM Employee emp WHERE emp.designation=?1")
	public List<Employee> getEmployeeByDesignation(String designation);
}
