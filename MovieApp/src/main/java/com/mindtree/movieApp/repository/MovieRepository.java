package com.mindtree.movieApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.movieApp.entity.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

	@Query("select m from Movie m where m.name=?1")
	public Optional<Movie> findByName(String name);
}
