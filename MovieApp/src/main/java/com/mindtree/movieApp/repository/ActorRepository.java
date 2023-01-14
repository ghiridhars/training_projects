package com.mindtree.movieApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.movieApp.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{
	
	@Query("select a from Actor a where a.name=?1")
	public Optional<List<Actor>> findByName(String name);

	
}
