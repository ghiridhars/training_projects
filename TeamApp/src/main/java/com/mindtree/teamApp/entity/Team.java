package com.mindtree.teamApp.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	private String name;
	private int maxLimit;

	@OneToMany(mappedBy = "team")
	private Set<Player> players;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int tId, String name, int maxLimit, Set<Player> players) {
		super();
		this.tId = tId;
		this.name = name;
		this.maxLimit = maxLimit;
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public int getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}

	@Override
	public String toString() {
		return "Team [tId=" + tId + ", name=" + name + ", maxLimit=" + maxLimit + ", players=" + players + "]";
	}

}
