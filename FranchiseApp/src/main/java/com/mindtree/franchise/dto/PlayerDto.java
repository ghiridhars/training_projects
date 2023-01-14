package com.mindtree.franchise.dto;

public class PlayerDto {

	private int id;

	private String name;
	private String type;
	private short age;

	private int teamId;

	public PlayerDto(int id, String name, String type, short age, int teamId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.teamId = teamId;
	}

	public PlayerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

}
