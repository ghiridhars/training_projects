package com.mindtree.personCountryApp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryDto {

	@NotNull(message = "Country ID should not be empty")
	private int countryId;
	
	@NotBlank(message = "Country Name should not be empty")
	@Size(max = 20,message = "Maximum length of Country name should be less than 20")
	private String countryName;
	
	@NotBlank(message = "Country Type should not be empty")
	@Size(max = 20,message = "Maximum length of Country Type should be less than 20")
	private String countryType;

	public CountryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryDto(int countryId, String countryName) {
		super();
		this.setCountryId(countryId);
		this.setCountryName(countryName);
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

	@Override
	public String toString() {
		return "CountryDto [countryId=" + countryId + ", countryName=" + countryName + ", countryType=" + countryType
				+ "]";
	}

}
