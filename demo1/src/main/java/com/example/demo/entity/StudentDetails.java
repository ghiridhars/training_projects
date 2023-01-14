package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StudentDetails {

	@Id
	private int personalId;
	private String address;
	private String cityname;

	@OneToOne
	@JsonIgnore // not using join column coz of jsonignore
	private Student student;

	public StudentDetails(int personalId, String address, String cityname, Student student) {
		super();
		this.personalId = personalId;
		this.address = address;
		this.cityname = cityname;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPersonalId() {
		return personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

}
