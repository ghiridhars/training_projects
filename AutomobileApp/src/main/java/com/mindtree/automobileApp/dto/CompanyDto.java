package com.mindtree.automobileApp.dto;

import java.util.List;

import com.mindtree.automobileApp.entity.Model;

public class CompanyDto {

	private int id;
	private String name;

	private List<Model> models;

	public CompanyDto(int id, String name, List<Model> models) {
		super();
		this.id = id;
		this.name = name;
		this.models = models;
	}

	public CompanyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "CompanyDto [id=" + id + ", name=" + name + ", models=" + models + "]";
	}
	

}
