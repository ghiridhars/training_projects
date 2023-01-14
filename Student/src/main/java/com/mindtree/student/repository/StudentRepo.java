package com.mindtree.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.student.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

	@Query("Select s from Student s where s.name=?1")
	public Optional<Student> findByName(String sName);
	
	@Query("Select s from Student s where s.className=?1")
	public List<Student> findByClass(String name);

}
