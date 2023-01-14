package com.mindtree.personCountryApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.personCountryApp.dto.StateDto;
import com.mindtree.personCountryApp.exception.ApplicationServiceException;
import com.mindtree.personCountryApp.exception.InvalidStateException;
import com.mindtree.personCountryApp.service.CountryService;
import com.mindtree.personCountryApp.service.StateService;

@Controller
@RequestMapping("/state")
public class StateController {

	@Autowired
	private StateService stateService;

	@Autowired
	private CountryService countryService;

//	@ModelAttribute
//	public StateDto updateState(byte age,String sub) {
//		StateDto sd = new StateDto();
//		sd.setSubject(sub);
//		sd.setAge(age);
//		return sd;
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/addState")
	public String addState(Model m) {
		try {
			m.addAttribute("countryList", countryService.getAllDetails());
			return "addState";
		} catch (ApplicationServiceException e) {
			e.printStackTrace();
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveState")
	public String saveState(@ModelAttribute("state") StateDto sDto, BindingResult br, Model m) {
		System.out.println(sDto);
		try {
			stateService.addStateByName(sDto, sDto.getCountryName());
			return "redirect:getStates";
		} catch (ApplicationServiceException e) {
			m.addAttribute("errors", br.getAllErrors());
			return "errors";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showState")
	public String showState(@Valid @ModelAttribute("state") StateDto sDto, BindingResult br, Model m) {

		try {
			if (!br.hasErrors()) {
				StateDto stu = stateService.addStateByName(sDto, sDto.getCountryName());

				System.out.println(sDto);
				return "redirect:getStates";

			} else {
				m.addAttribute("errors", br.getAllErrors());
				return "errors";
			}
		} catch (ApplicationServiceException e) {
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editState/{stateName}")
	public String editState(@PathVariable("stateName") String stateName, Model m) {
		StateDto s;
		try {
			s = stateService.getStateByName(stateName);
			System.out.println(s);
			m.addAttribute("state",s);
			return "editState";
		} catch (ApplicationServiceException e) {
			e.printStackTrace();
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/showStates")
	public String getStatesById(@ModelAttribute("countryId") int id, BindingResult br, Model m) {
		System.out.println("Getting States");
		List<StateDto> stu;
		try {
			stu = countryService.getStatesById(id);
			m.addAttribute("countryList", countryService.getAllDetails());
			m.addAttribute("stateList", stu);
			return "getState";
		} catch (ApplicationServiceException e) {
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getStates")
	public String getAllStates(Model m) {
		System.out.println("Getting all States");
		try {
			m.addAttribute("stateList", stateService.getAllStates());
			return "getState";
		} catch (ApplicationServiceException e) {
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}
	}
}
