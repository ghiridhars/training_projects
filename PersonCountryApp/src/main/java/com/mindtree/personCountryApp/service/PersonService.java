package com.mindtree.personCountryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.personCountryApp.dto.PersonDto;
import com.mindtree.personCountryApp.dto.StateDto;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;
import com.mindtree.personCountryApp.exception.InvalidStateException;

@Service
public interface PersonService {

	PersonDto addPersonByState(PersonDto s, int id) throws ApplicationServiceException;

	PersonDto addPersonByName(PersonDto s, String name) throws ApplicationServiceException;

	List<PersonDto> getPersonsByState(String name)throws ApplicationServiceException;

}
