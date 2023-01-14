package com.mindtree.student.dto;

import java.util.Set;

public class StudentDto {

	private int id;
	private String name;
	private String gender;
	private String className;
	private Set<String> subjects;

	public StudentDto(int id, String name, String gender, String className, Set<String> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.className = className;
		this.subjects = subjects;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", gender=" + gender + ", className=" + className
				+ ", subjects=" + subjects + "]";
	}

}
