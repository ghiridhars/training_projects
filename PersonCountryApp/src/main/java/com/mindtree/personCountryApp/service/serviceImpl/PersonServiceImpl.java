package com.mindtree.personCountryApp.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.personCountryApp.dto.PersonDto;
import com.mindtree.personCountryApp.dto.StateDto;
import com.mindtree.personCountryApp.entity.Country;
import com.mindtree.personCountryApp.entity.Person;
import com.mindtree.personCountryApp.entity.State;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;
import com.mindtree.personCountryApp.exception.InvalidCountryException;
import com.mindtree.personCountryApp.exception.InvalidPersonException;
import com.mindtree.personCountryApp.exception.InvalidStateException;
import com.mindtree.personCountryApp.repository.PersonRepo;
import com.mindtree.personCountryApp.repository.StateRepo;
import com.mindtree.personCountryApp.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private PersonRepo personRepo;

	ModelMapper model = new ModelMapper();

	public PersonDto entityToDto(Person e) {
		ModelMapper mapper = new ModelMapper();
		PersonDto map = mapper.map(e, PersonDto.class);
		return map;
	}

	public StateDto entityToDto(State e) {
		ModelMapper mapper = new ModelMapper();
		StateDto map = mapper.map(e, StateDto.class);
		return map;
	}

	public List<StateDto> entityToDTo(List<State> stu) {
		return stu.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public Person dtoToEntity(PersonDto edto) {
		Person emp = new Person();
		ModelMapper mapper = new ModelMapper();
		Person map = mapper.map(edto, Person.class);
		return map;
	}

	public State dtoToEntity(StateDto edto) {
		State emp = new State();
		ModelMapper mapper = new ModelMapper();
		State map = mapper.map(edto, State.class);
		return map;
	}

	public List<Person> dtoToEntity(List<PersonDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<PersonDto> entityToDto(List<Person> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public PersonDto entityToDTO(Person p) {
		Person emp = new Person();
		ModelMapper mapper = new ModelMapper();
		PersonDto map = mapper.map(p, PersonDto.class);
		return map;
	}

	public List<PersonDto> entityToDTO(List<Person> pList) {
		return pList.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
	}

//	@Override
//	public boolean save(PersonDto s) {
//		personRepo.save(dtoToEntity(s));
//		return true;
//	}

	@Override
	public PersonDto addPersonByState(PersonDto s, int id) throws ApplicationServiceException {
		List<State> stuList = stateRepo.findAll();
		State sta = null;
		Person per = dtoToEntity(s);
		Set<State> li = new HashSet<>();

		try {
			sta = stateRepo.findById(id).orElseThrow(() -> new InvalidPersonException("Person Not found"));
			per.setState(sta);
			per = personRepo.save(per);
			sta = stateRepo.save(sta);
		} catch (InvalidPersonException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		System.out.println("Added Details");
		System.out.println(entityToDto(per));
		return entityToDto(per);
	}

	@Override
	public PersonDto addPersonByName(PersonDto s, String name) throws ApplicationServiceException {
		List<State> stuList = stateRepo.findAll();
		State sta = null;
		Person per = dtoToEntity(s);
		Set<State> li = new HashSet<>();

		try {
			sta = stateRepo.findStateByName(name).orElseThrow(() -> new InvalidStateException("State Not found"));
			per.setState(sta);
			per = personRepo.save(per);
			sta = stateRepo.save(sta);
		} catch (InvalidStateException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		System.out.println("Added Details");
		System.out.println(entityToDto(per));
		return entityToDto(per);
	}

	@Override
	public List<PersonDto> getPersonsByState(String name) throws ApplicationServiceException {
		State result = null;
		List<Person> pList = null;
		try {
			result = stateRepo.findStateByName(name)
					.orElseThrow(() -> new InvalidCountryException("Country Not found"));

			pList = personRepo.findPersonByState(name).orElseThrow(() -> new InvalidStateException("Cant get data"));

		} catch (InvalidCountryException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		System.out.println(entityToDTO(pList));
		return entityToDTO(pList);
	}

}
