package com.mindtree.personCountryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.personCountryApp.dto.StateDto;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;
import com.mindtree.personCountryApp.exception.InvalidStateException;

@Service
public interface StateService {

	StateDto addStateById(StateDto s, int id) throws ApplicationServiceException;

	boolean save(StateDto s)throws ApplicationServiceException;

	List<StateDto> getAllStates()throws ApplicationServiceException;

	StateDto addStateByName(StateDto sDto, String countryName)throws ApplicationServiceException;

	List<StateDto> getStatesByName(String name) throws ApplicationServiceException;

	StateDto getStateByName(String stateName)throws ApplicationServiceException;
}
