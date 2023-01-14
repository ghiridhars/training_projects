package com.mindtree.insuranceCompanyApp.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mindtree.insuranceCompanyApp.entity.Policy;

import lombok.Data;

public class CompanyDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8931361267158853394L;

	@NotNull(message = "ID should not be empty")
	private int id;

	@NotEmpty(message = "Name should not be empty")
	@Size(min = 4, message = "Minimum 4 characters")
	private String name;

//	private Policy[] policies;

	public CompanyDto(@NotNull(message = "ID should not be empty") int id,
			@NotEmpty(message = "Name should not be empty") @Size(min = 4, message = "Minimum 4 characters") String name
//			Policy[] policies
			) {
		super();
		this.id = id;
		this.name = name;
//		this.policies = policies;
	}

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Policy[] getPolicies() {
//		return policies;
//	}
//
//	public void setPolicies(Policy[] policies) {
//		this.policies = policies;
//	}

}
