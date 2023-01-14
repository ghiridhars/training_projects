package com.mindtree.movieApp.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDto {

	private int id;

	@NotBlank(message = "Username cannot be empty.")
	private String username;

	@NotBlank(message = "Password cannot be empty.")
	private String password;

	public UserDto(int id, @NotBlank(message = "Username cannot be empty.") String username,
			@NotBlank(message = "Password cannot be empty.") String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
