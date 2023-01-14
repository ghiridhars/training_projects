package com.mindtree.franchise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.franchise.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
