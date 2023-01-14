package com.mindtree.movieApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "actor")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private float budget;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@ManyToOne
	@JsonIgnore
	private Movie movie;

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(int id, String name, String gender, float budget, Date createdDate, Movie movie) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.budget = budget;
		this.createdDate = createdDate;
		this.movie = movie;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", gender=" + gender + ", budget=" + budget + ", createdDate="
				+ createdDate + ", movie=" + movie + "]";
	}

}
