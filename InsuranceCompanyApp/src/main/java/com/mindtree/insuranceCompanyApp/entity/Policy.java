package com.mindtree.insuranceCompanyApp.entity;

import java.io.Serializable;
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
@Table(name = "policy")
public class Policy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1317277517937188993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private float premium;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@ManyToOne
	@JsonIgnore
	private Company company;

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(int id, String name, float premium, Date createdDate, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.premium = premium;
		this.createdDate = createdDate;
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

	public float getPremium() {
		return premium;
	}

	public void setPremium(float premium) {
		this.premium = premium;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", name=" + name + ", premium=" + premium + "]";
	}

}
