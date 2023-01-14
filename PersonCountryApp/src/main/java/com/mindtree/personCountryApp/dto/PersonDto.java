package com.mindtree.personCountryApp.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {

	@NotNull(message = "Person ID should not be empty")
	private int personId;
	
	@NotBlank(message = "Country Name should not be empty")
	@Size(max = 20,message = "Maximum length of Country name should be less than 20")
	private String name;
	
	private List<String> hobbies;

	@NotBlank(message = "Gender should not be empty")
	@Size(max = 7,message = "Maximum length of Gender should be less than 7")
	private String gender;

	private String stateName;

	public PersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDto(int personId, String name, List<String> hobbies, String gender, String stateName) {
		super();
		this.personId = personId;
		this.name = name;
		this.hobbies = hobbies;
		this.gender = gender;
		this.stateName = stateName;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public int getPersonId() {
		return personId;
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "PersonDto [personId=" + personId + ", name=" + name + ", hobbies=" + hobbies + ", gender=" + gender
				+ ", stateName=" + stateName + "]";
	}

}
