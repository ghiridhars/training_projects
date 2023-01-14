package com.mindtree.insuranceCompanyApp.exception;

import java.util.Date;

public class ErrorDetails {

	private String message;
	private Date timestamp;
	private String description;

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String message, Date timestamp, String description) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
