package com.mindtree.automobileApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.automobileApp.entity.Model;

@Repository
public interface ModelRepo extends JpaRepository<Model, Integer>{

	
}
