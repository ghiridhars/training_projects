package com.mindtree.collegeManagement.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CollegeDto {

	private int collegeId;
	private String collegeName;
	private short strength;

	public CollegeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollegeDto(int collegeId, String collegeName, short strength) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.strength = strength;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public short getStrength() {
		return strength;
	}

	public void setStrength(short strength) {
		this.strength = strength;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
}