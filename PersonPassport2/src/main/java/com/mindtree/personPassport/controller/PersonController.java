package com.mindtree.personPassport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.personPassport.entity.Passport;
import com.mindtree.personPassport.entity.Person;
import com.mindtree.personPassport.exception.InvalidPasspportException;
import com.mindtree.personPassport.exception.InvalidPersonException;
import com.mindtree.personPassport.service.PersonService;
import com.mindtree.personPassport.service.serviceImpl.PersonServiceImpl;

@RestController
@RequestMapping("/Person")
public class PersonController {

	@Autowired
	private PersonServiceImpl personService;

	@RequestMapping("/getAllPersons")
	public List<Person> getAllPersons() {
		System.out.println("Getting all students");
		return personService.getAllPersons();
	}

	@RequestMapping("/getPerson/{id}")
	public Person getPerson(@PathVariable int id) {
		Person per = null;
		System.out.println("Getting passport by id");
		try {
			per = personService.getPersonById(id);
		} catch (InvalidPersonException e) {
			e.printStackTrace();
		}
		return per;
	}

	@PostMapping(value = "/addPerson",
			produces = MediaType.APPLICATION_XML_VALUE,
			consumes = MediaType.APPLICATION_XML_VALUE)
	public Person addPerson(@RequestBody Person s) {
		return personService.addPerson(s);
	}

}
