package com.mindtree.personPassport.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="passport")
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passportId;
	private String passportNo;

	@OneToOne
	@JsonIgnore
	private Person person;

	public Passport() {
		super();
	}

	public Passport(int passportId, String passportNo, Person person) {
		super();
		this.passportId = passportId;
		this.passportNo = passportNo;
		this.person = person;
	}

	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
