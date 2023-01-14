package com.mindtree.webAppDemo.dto;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeDto {

	private int id;

	@NotBlank(message = "Username cannot be empty.")
	private String name;

	@NotBlank(message = "Designation cannot be empty.")
	private String designation;

	@Min(200000)
	@NotNull
	private float salary;

	@NotBlank(message = "Gender cannot be empty.")
	private String gender;

	@Size(min = 1, max = 2, message = "Hobbies should be 2.")
	private Set<String> hobbies;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(int id, @NotBlank(message = "Username cannot be empty.") String name,
			@NotBlank(message = "Designation cannot be empty.") String designation, @Min(200000) @NotNull float salary,
			@NotBlank(message = "Gender cannot be empty.") String gender,
			@Size(min = 1, max = 2, message = "Hobbies should be 2.") Set<String> hobbies) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.gender = gender;
		this.hobbies = hobbies;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}

}
