package com.mindtree.teamApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.teamApp.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Query("select count(*) from Player")
	public int getCountPlayer();
}
