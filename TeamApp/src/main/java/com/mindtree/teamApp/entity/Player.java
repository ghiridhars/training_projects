package com.mindtree.teamApp.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;

	private String name;

	@ElementCollection
	@CollectionTable(name = "playerType", joinColumns = @JoinColumn(referencedColumnName = "playerId"))
	private List<String> type;
	private short age;

	@ManyToOne
	@JsonIgnore
	private Team team;

	public Player(int playerId, String name, List<String> type, short age, Team team) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.type = type;
		this.age = age;
		this.setTeam(team);
	}

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
