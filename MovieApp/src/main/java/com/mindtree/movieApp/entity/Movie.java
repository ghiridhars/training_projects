package com.mindtree.movieApp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private float highestBudget;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@OneToMany(mappedBy = "movie")
	private List<Actor> actors;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String name, float highestBudget, Date createdDate, List<Actor> actors) {
		super();
		this.id = id;
		this.name = name;
		this.highestBudget = highestBudget;
		this.createdDate = createdDate;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}
