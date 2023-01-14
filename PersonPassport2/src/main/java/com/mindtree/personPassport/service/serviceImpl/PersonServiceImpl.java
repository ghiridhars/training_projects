package com.mindtree.personPassport.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.personPassport.entity.Passport;
import com.mindtree.personPassport.entity.Person;
import com.mindtree.personPassport.exception.InvalidPasspportException;
import com.mindtree.personPassport.exception.InvalidPersonException;
import com.mindtree.personPassport.repository.PersonRepo;

@Service
public class PersonServiceImpl {
	
	@Autowired
	private PersonRepo personRepo;

	List<Person> personList = new ArrayList<>();

	public List<Person> getAllPersons() {
		List<Person> li= new ArrayList<>();
		personRepo.findAll().forEach(li::add);
		return li;
	}
	
	public Person getPersonById(int id) throws InvalidPersonException {
		Person result = personRepo.findById(id).orElse(null);
		if(result == null)
			throw new InvalidPersonException("Passport ID not found");
		else
			return result;
	}
	
	public Person addPerson(Person s){
		System.out.println("Added");
		return personRepo.save(s);
	}
}
