package com.mindtree.personCountryApp.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String name;

	@ElementCollection
	@CollectionTable(name = "person_hobbies", joinColumns = @JoinColumn(name = "personId"))
	@Column(name = "hobby")
	private Set<String> hobbies;

	private String gender;

	@OneToOne
	private State state;

	public int getPersonId() {
		return personId;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String name, Set<String> hobbies, String gender, State state) {
		super();
		this.personId = personId;
		this.name = name;
		this.hobbies = hobbies;
		this.gender = gender;
		this.state = state;
	}

	public Set<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
