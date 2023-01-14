package com.mindtree.teamApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.teamApp.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer > {

}
