package com.mindtree.automobileApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.automobileApp.dto.CompanyDto;
import com.mindtree.automobileApp.exception.AutomobileCompanyAppException;
import com.mindtree.automobileApp.exception.ServiceException;
import com.mindtree.automobileApp.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/addCompany")
	public ResponseEntity<?> addCompany(@RequestBody CompanyDto cDto) throws AutomobileCompanyAppException {

		CompanyDto c = null;
		try {
			c = companyService.addCompany(cDto);
			return new ResponseEntity(c, HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			throw new AutomobileCompanyAppException(e.getMessage(), e);
		}

	}

	@RequestMapping("/getAllCompanies")
	public ResponseEntity<?> getAllCompanies() throws AutomobileCompanyAppException {

		List<CompanyDto> c = null;
		try {
			c = companyService.getAllCompanies();
			return new ResponseEntity(c, HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			throw new AutomobileCompanyAppException(e.getMessage(), e);
		}

	}

	@RequestMapping("/getSortedCompanies/{color}/{name}")
	public ResponseEntity<?> getSortedCompanies(@PathVariable String color,@PathVariable String name) throws AutomobileCompanyAppException {

		CompanyDto c = null;
		try {
			c = companyService.getSortedCompanies(color, name);
			return new ResponseEntity(c, HttpStatus.ACCEPTED);
		} catch (ServiceException e) {
			throw new AutomobileCompanyAppException(e.getMessage(), e);
		}
	}

}
