package com.mindtree.personCountryApp.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int countryId;
	private String countryName;
	private String countryType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
	private List<State> states;

	public Country(int countryId, String countryName, String countryType, Date createdDate, List<State> states) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryType = countryType;
		this.createdDate = createdDate;
		this.states = states;
	}

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryType() {
		return countryType;
	}

	public void setCountryType(String countryType) {
		this.countryType = countryType;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + ", countryType=" + countryType
				+ ", createdDate=" + createdDate + "]";
	}

}
