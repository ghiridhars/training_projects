package com.mindtree.automobileApp.entity;

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
@Table(name = "model")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String color;
	private float price;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@ManyToOne
	@JsonIgnore
	private Company company;

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Model(int id, String name, String color, float price, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.company = company;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", color=" + color + ", company=" + company + "]";
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
