package com.mindtree.movieApp.exception;

import java.util.Date;

public class ErrorDetails {

	private String name;
	private String dscription;
	private Date timestamp;

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String name, String dscription, Date timestamp) {
		super();
		this.name = name;
		this.dscription = dscription;
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDscription() {
		return dscription;
	}

	public void setDscription(String dscription) {
		this.dscription = dscription;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
