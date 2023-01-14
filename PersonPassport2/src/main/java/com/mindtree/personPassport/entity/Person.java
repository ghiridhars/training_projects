package com.mindtree.personPassport.entity;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String birthPlace;
	private byte age;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
	private Passport passport;

	public Person(int id, String name, String birthPlace, byte age, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.birthPlace = birthPlace;
		this.age = age;
		this.passport = passport;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	// (fetch=FetchType.LAZY,mappedBy = "student")
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

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

}
