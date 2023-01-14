package com.mindtree.automobileApp.service;

import java.util.List;

import com.mindtree.automobileApp.dto.CompanyDto;
import com.mindtree.automobileApp.dto.ModelDto;
import com.mindtree.automobileApp.exception.ServiceException;

public interface CompanyService {

	public CompanyDto addCompany(CompanyDto c) throws ServiceException;

	public List<CompanyDto> getAllCompanies() throws ServiceException;

	public CompanyDto getSortedCompanies(String color, String name) throws ServiceException;

}
