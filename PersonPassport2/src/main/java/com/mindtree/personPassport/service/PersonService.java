package com.mindtree.personPassport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.personPassport.entity.Person;

@Service
public interface PersonService {
	
	public List<Person> getAllPersons();
	
	public Person getPersonByName(int id);
	
	public Person addPerson(Person s);
}
