package com.mindtree.personCountryApp.service.serviceImpl;

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
import com.mindtree.personCountryApp.repository.CountryRepo;
import com.mindtree.personCountryApp.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepo countryRepo;
	
	ModelMapper model = new ModelMapper();
	
	public CountryDto entityToDto(Country e) {
		ModelMapper mapper = new ModelMapper();
		CountryDto map = mapper.map(e, CountryDto.class);
		return map;
	}
	
	public StateDto entityToDto(State e) {
		ModelMapper mapper = new ModelMapper();
		StateDto map = mapper.map(e, StateDto.class);
		return map;
	}

	public List<StateDto> entityToDTo(Set<State> li) {
		return li.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
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
	
	public List<Country> dtoToEntity(Set<CountryDto> dto) {
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

	public List<CountryDto> entityToDto(Set<Country> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	public List<CountryDto> entityToDto(List<Country> emp) {
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	@Override
	public List<CountryDto> getAllDetails() throws ApplicationServiceException {
		Set<Country> out = null;
		try {
			List<Country> li = countryRepo.findAll();
			out = new HashSet<>(li);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationServiceException(e+"\nService layer Exception when getting all details.");
		}
		System.out.println(entityToDto(out));
		return entityToDto(out);
	}

	@Override
	public CountryDto getCountryById(int id) throws ApplicationServiceException {
		Country result = null;
		try {
			result = countryRepo.findById(id).orElseThrow(() -> new InvalidCountryException("Country ID not found in database"));
		} catch (InvalidCountryException e) {
			e.printStackTrace();
			throw new ApplicationServiceException(e+"\nService layer Exception:when getting Country details by id.");
		}
		return entityToDto(result);
	}

	@Override
	public CountryDto addCountry(CountryDto s) throws ApplicationServiceException {
		System.out.println("Added");
		try {
			List<Country> cList = countryRepo.findAll();
			Iterator<Country> itr = cList.iterator();
			while(itr.hasNext()) {
				Country stu= itr.next();
				if(stu.getCountryName().equals(s.getCountryName())) {
					throw new InvalidCountryException("Invalid Country Name:Country Name already present");			
				}
			}
			countryRepo.save(dtoToEntity(s));
		} catch (InvalidCountryException e) {
			e.printStackTrace();
			throw new ApplicationServiceException(e+"\nService layer Exception when adding details to db.");
		}
		return s;
	}

	@Override
	public List<StateDto> getStatesById(int id) throws ApplicationServiceException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<StateDto> getStatesById(int id) throws ApplicationServiceException {
//		Country col=null;
//		try {
//			col = countryRepo.findById(id).orElse(null);
//			Set<State> li = new HashSet<>();
//			if(col!=null)
//				li = col.getStates();
//			else
//				throw new InvalidCountryException("Country not found");
//			return entityToDTo(li);
//		} catch (InvalidCountryException e) {
//			e.printStackTrace();
//			throw new ApplicationServiceException("Service layer Exception when getting details by id.");
//		}
//	}

}
