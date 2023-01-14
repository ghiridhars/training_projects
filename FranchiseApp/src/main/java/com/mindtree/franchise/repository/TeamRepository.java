package com.mindtree.franchise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.franchise.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer > {

}
