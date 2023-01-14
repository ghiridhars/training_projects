package com.mindtree.insuranceCompanyApp.service;

import java.util.List;

import com.mindtree.insuranceCompanyApp.dto.PolicyDto;
import com.mindtree.insuranceCompanyApp.exception.PolicyServiceException;

public interface PolicyService{
	
	public PolicyDto addPolicyByName(PolicyDto pDto,String name) throws PolicyServiceException;
	
	public List<PolicyDto> getAllPolicies()throws PolicyServiceException;

	public PolicyDto getPolicy(int id)throws PolicyServiceException;
	
}
