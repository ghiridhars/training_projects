package com.mindtree.collegeManagement.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentDto {

	private int studentId;
	private String name;
	private String subject;
	private byte age;

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(String name, String subject, byte age) {
		super();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}
}
