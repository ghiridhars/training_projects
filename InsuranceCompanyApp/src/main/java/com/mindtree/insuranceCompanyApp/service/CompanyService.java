package com.mindtree.insuranceCompanyApp.service;

import java.util.List;

import com.mindtree.insuranceCompanyApp.dto.CompanyDto;
import com.mindtree.insuranceCompanyApp.dto.PolicyDto;
import com.mindtree.insuranceCompanyApp.entity.Company;
import com.mindtree.insuranceCompanyApp.exception.CompanyServiceException;

public interface CompanyService {
	
	public List<CompanyDto> getAllCompanies() throws CompanyServiceException;
	
	public CompanyDto addCompany(CompanyDto cDto)throws CompanyServiceException;
	
	public Company[] getSortedCompanies()throws CompanyServiceException;

	public CompanyDto updateCompanyById(CompanyDto cDto, int id) throws CompanyServiceException;

	public CompanyDto getCompany(int id)throws CompanyServiceException;

}
