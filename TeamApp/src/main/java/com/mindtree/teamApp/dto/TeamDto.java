package com.mindtree.teamApp.dto;

public class TeamDto {

	private int id;
	private String teamName;
	private byte maxLimit;

	public TeamDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamDto(int id, String teamName, byte maxLimit) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.maxLimit = maxLimit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(byte maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "TeamDto [id=" + id + ", teamName=" + teamName + ", maxLimit=" + maxLimit + "]";
	}

}
