package com.mindtree.movieApp.dto;

import java.util.List;

import com.mindtree.movieApp.entity.Actor;

public class MovieDto {

	private int id;

	private String name;
	private float highestBudget;

	private List<ActorDto> actors;

	public MovieDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieDto(int id, String name, float highestBudget, List<ActorDto> actors) {
		super();
		this.id = id;
		this.name = name;
		this.highestBudget = highestBudget;
		this.actors = actors;
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

	public float getHighestBudget() {
		return highestBudget;
	}

	public void setHighestBudget(float highestBudget) {
		this.highestBudget = highestBudget;
	}

	public List<ActorDto> getActors() {
		return actors;
	}

	public void setActors(List<ActorDto> actors) {
		this.actors = actors;
	}

}
