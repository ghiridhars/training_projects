package com.mindtree.teamApp.dto;

import java.util.List;

public class PlayerDto {

	private int id;

	private String playerName;
	private List<String> type;
	private short age;

	private int teamId;

	public PlayerDto(int id, String playerName, List<String> type, short age, int teamId) {
		super();
		this.id = id;
		this.playerName = playerName;
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

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

}
