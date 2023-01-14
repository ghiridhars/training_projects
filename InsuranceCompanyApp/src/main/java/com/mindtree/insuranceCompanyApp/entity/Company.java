package com.mindtree.insuranceCompanyApp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6752899529871593380L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@OneToMany(mappedBy="company")
	private List<Policy> policies;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String name, Date createdDate, List<Policy> policies) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
		this.policies = policies;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", policies=" + policies + "]";
	}


}
