package com.mindtree.automobileApp.exception;

import java.util.Date;

public class ErrorDetails {

	private String message;
	private Date timestamp;
	private String description;

	public ErrorDetails(String message, Date timestamp, String description) {
		super();
		this.setMessage(message);
		this.setTimestamp(timestamp);
		this.setDescription(description);
	}

	public ErrorDetails() {
		super();
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
