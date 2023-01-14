package com.mindtree.insuranceCompanyApp.service.serviceImpl;

import java.util.Comparator;


import com.mindtree.insuranceCompanyApp.entity.Company;

public class CompanyComparator implements Comparator<Company>{

	@Override
	public int compare(Company o1, Company o2) {
		return o2.getName().compareTo(o1.getName());
	}
}
