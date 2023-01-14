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

import com.mindtree.personCountryApp.dto.CountryDto;
import com.mindtree.personCountryApp.dto.StateDto;
import com.mindtree.personCountryApp.entity.Country;
import com.mindtree.personCountryApp.entity.State;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;
import com.mindtree.personCountryApp.exception.InvalidCountryException;
import com.mindtree.personCountryApp.exception.InvalidStateException;
import com.mindtree.personCountryApp.repository.CountryRepo;
import com.mindtree.personCountryApp.repository.StateRepo;
import com.mindtree.personCountryApp.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private CountryRepo countryRepo;

	ModelMapper model = new ModelMapper();

	public StateDto entityToDto(State e) {
		ModelMapper mapper = new ModelMapper();
		StateDto map = mapper.map(e, StateDto.class);
		return map;
	}

	public State dtoToEntity(StateDto edto) {
		State emp = new State();
		ModelMapper mapper = new ModelMapper();
		State map = mapper.map(edto, State.class);
		return map;
	}

	public List<State> dtoTOEntity(List<StateDto> stu) {
		return stu.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<StateDto> entityToDTo(List<State> stu) {
		return stu.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public CountryDto entityToDto(Country e) {
		ModelMapper mapper = new ModelMapper();
		CountryDto map = mapper.map(e, CountryDto.class);
		return map;
	}

	public Country dtoToEntity(CountryDto edto) {
		Country emp = new Country();
		ModelMapper mapper = new ModelMapper();
		Country map = mapper.map(edto, Country.class);
		return map;
	}

	public List<Country> dtoToEntity(List<CountryDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<CountryDto> entityToDto(List<Country> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	List<State> StateList = new ArrayList<>();

	@Override
	public List<StateDto> getAllStates() {
		List<State> li = new ArrayList<>();
		stateRepo.findAll().forEach(li::add);
		System.out.println(entityToDTo(li));
		return entityToDTo(li);
	}

	@Override
	public List<StateDto> getStatesByName(String name) throws ApplicationServiceException {
		Country result = null;
		List<State> sList = null;
		try {
			result = countryRepo.findCountryByName(name)
					.orElseThrow(() -> new InvalidCountryException("Country Not found"));
			Set<State> s = new HashSet<>();
			sList = new ArrayList<State>(result.getStates());
		} catch (InvalidCountryException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		return entityToDTo(sList);
	}

	@Override
	public boolean save(StateDto sDto) {
		
		State s = dtoToEntity(sDto);
		System.out.println("sdsds"+s);
		stateRepo.save(s);
		return true;
	}

	@Override
	public StateDto addStateById(StateDto s, int id) throws ApplicationServiceException {
		List<State> stuList = stateRepo.findAll();
		Country coun = countryRepo.findById(id).orElseThrow(() -> new InvalidCountryException("Country Not found"));
		State state = dtoToEntity(s);
		Set<State> li = new HashSet<>();

		try {
			coun = countryRepo.findById(id).orElseThrow(() -> new InvalidCountryException("Country Not found"));
			state.setCountry(coun);
			state = stateRepo.save(state);
			coun = countryRepo.save(coun);
		} catch (InvalidCountryException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		System.out.println("Added Details");
		System.out.println(entityToDto(state));
		return entityToDto(state);
	}

	@Override
	public StateDto addStateByName(StateDto sDto, String countryName) throws ApplicationServiceException {
		List<State> stuList = stateRepo.findAll();
		Country coun = null;
		State state = dtoToEntity(sDto);
		Set<State> li = new HashSet<>();

		try {
			coun = countryRepo.findCountryByName(countryName)
					.orElseThrow(() -> new InvalidCountryException("Country Not found"));
			state.setCountry(coun);
			state = stateRepo.save(state);
			coun = countryRepo.save(coun);
		} catch (InvalidCountryException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		System.out.println("Added Details");
		System.out.println(entityToDto(state));
		return entityToDto(state);
	}

	@Override
	public StateDto getStateByName(String stateName) throws ApplicationServiceException {
		State s = null;
		try {
			s = stateRepo.findStateByName(stateName).orElseThrow(() -> new InvalidStateException("State Not found"));
		} catch (InvalidStateException e) {
			throw new ApplicationServiceException(e.getMessage(), e);
		}
		return entityToDto(s);
	}
}
