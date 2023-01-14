package com.mindtree.loginApp.dto;

public class UserDto {

	private int id;
	private String name;
	private String emailId;
	private String password;
	private long contactNo;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(int id, String name, String emailId, String password, long contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.contactNo = contactNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contatctNo) {
		this.contactNo = contatctNo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", emailId=" + emailId + ", password=" + password + ", contatctNo="
				+ contactNo + "]";
	}
}
