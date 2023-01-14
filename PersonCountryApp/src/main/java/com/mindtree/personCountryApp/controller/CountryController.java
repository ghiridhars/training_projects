package com.mindtree.personCountryApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.personCountryApp.dto.CountryDto;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;
import com.mindtree.personCountryApp.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(method = RequestMethod.GET, value = "/addCountry")
	public String addCountry() {
		return "addCountry";
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/showCountry")
	public String showCountry(@Valid @ModelAttribute("country")CountryDto  cDto,BindingResult br,Model m) {
		
		try {
			if(!br.hasErrors()) {
				countryService.addCountry(cDto);
				return "redirect:getAllCountrys";
			}
			else {
				m.addAttribute("errors", br.getAllErrors());
				return "errors";
			}
		} catch (ApplicationServiceException e) {
			e.printStackTrace();
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllCountrys")
	public String getAllEmployees(Model m) {
		System.out.println("Getting all Countries");
		try {
			m.addAttribute("countryList", countryService.getAllDetails());
			return "getCountry";
		} catch (ApplicationServiceException e) {
			e.printStackTrace();
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}
	
}
