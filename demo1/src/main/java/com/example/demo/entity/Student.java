package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToOne(fetch=FetchType.LAZY,mappedBy = "student", cascade = CascadeType.ALL)
	private StudentDetails details;

//	(fetch=FetchType.LAZY,mappedBy = "student")
	public Student() {
		super();
	}

	public Student(int id, String name, StudentDetails details) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
	}

	public StudentDetails getDetails() {
		return details;
	}

	public void setDetails(StudentDetails details) {
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
