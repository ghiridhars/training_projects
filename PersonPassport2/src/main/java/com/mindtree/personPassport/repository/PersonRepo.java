package com.mindtree.personPassport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.personPassport.entity.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer>{
	

}
