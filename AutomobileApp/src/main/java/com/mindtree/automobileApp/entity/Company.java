package com.mindtree.automobileApp.entity;

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
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@OneToMany(mappedBy = "company")
	private List<Model> models;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String name, List<Model> models) {
		super();
		this.id = id;
		this.setName(name);
		this.models = models;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
