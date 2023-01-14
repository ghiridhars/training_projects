package com.mindtree.webAppDemo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.webAppDemo2.entity.Employee;


@Repository("empRepo")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
