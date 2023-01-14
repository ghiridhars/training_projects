package com.mindtree.personCountryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.personCountryApp.dto.CountryDto;
import com.mindtree.personCountryApp.dto.StateDto;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;

@Service
public interface CountryService{

	List<StateDto> getStatesById(int id) throws ApplicationServiceException;

	CountryDto addCountry(CountryDto s) throws ApplicationServiceException;

	CountryDto getCountryById(int id) throws ApplicationServiceException;

	List<CountryDto> getAllDetails() throws ApplicationServiceException;

}
