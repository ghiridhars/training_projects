package com.mindtree.automobileApp.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.automobileApp.dto.ModelDto;
import com.mindtree.automobileApp.exception.ServiceException;


public interface ModelService {

	public ModelDto addModel(ModelDto m,String name) throws ServiceException;

	public List<ModelDto> getAllModels() throws ServiceException;

	public Optional<Float> getAverage(String name) throws ServiceException;

	public List<ModelDto> getSortedModels(String color, String name) throws ServiceException;
	

}
