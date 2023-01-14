package com.mindtree.personCountryApp.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StateDto {

	private int stateId;
	
	@NotBlank(message = "State name should not be empty")
	@Size(max = 15,message = "Maximum length of State name should be less than 15")
	private String stateName;
	
	@NotNull(message = "population should not be empty")
	@Min(value = 100000,message = "population should be more than 1 lakh")
	private long population;
	private String captial;

	private String countryName;

	public StateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StateDto(int stateId, String stateName, long population, String captial, String countryName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.population = population;
		this.captial = captial;
		this.countryName = countryName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public long getPopulation() {
		return population;
	}

	public String getCaptial() {
		return captial;
	}

	public void setCaptial(String captial) {
		this.captial = captial;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "StateDto [stateId=" + stateId + ", stateName=" + stateName + ", population=" + population + ", captial="
				+ captial + ", countryName=" + countryName + "]";
	}

}
