package com.mindtree.movieApp.dto;

import com.mindtree.movieApp.entity.Movie;

public class ActorDto {

	private int id;
	private String name;
	private String gender;
	private float budget;
	

	public ActorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActorDto(int id, String name, String gender, float budget, Movie movie) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.budget = budget;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
}
