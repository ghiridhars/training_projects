package com.mindtree.collegeManagement.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	private String subject;
	private byte age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private College college;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, String subject, byte age, College college) {
		super();
		this.name = name;
		this.subject = subject;
		this.age = age;
		this.college = college;
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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

}
