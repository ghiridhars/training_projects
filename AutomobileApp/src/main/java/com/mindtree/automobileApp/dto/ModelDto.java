package com.mindtree.automobileApp.dto;

import com.mindtree.automobileApp.entity.Company;

public class ModelDto {

	private int id;
	private String name;
	private String color;
	private float price;
	
	private Company company;

	public ModelDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelDto(int id, String name, String color) {
		super();
		this.setId(id);
		this.setName(name);
		this.setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ModelDto [id=" + id + ", name=" + name + ", color=" + color + "]";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


}
