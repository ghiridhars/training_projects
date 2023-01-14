package com.mindtree.webAppDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.webAppDemo.entity.Employee;

@Repository("empRepo")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
