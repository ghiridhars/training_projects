package com.mindtree.CollegeApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.CollegeApp.dto.CollegeDto;
import com.mindtree.CollegeApp.exception.CollegeServiceException;
import com.mindtree.CollegeApp.service.CollegeServiceImpl;

@Controller
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeServiceImpl collegeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/addCollege")
	public String addCollege(Model m) {
		CollegeDto c = new CollegeDto();
		m.addAttribute("college",c);
		return "addCollege";
	}
		
	@RequestMapping(method = RequestMethod.POST, value = "/showCollege")
	public String showCollege(@Valid @ModelAttribute("college")CollegeDto  cDto,BindingResult br,Model m) {
		
		try {
			if(!br.hasErrors()) {
				collegeService.addCollege(cDto);
				return "redirect:getAllColleges";
			}
			else {
//				m.addAttribute("errors", br.getFieldError().getDefaultMessage());
				return "addCollege";
			}
		} catch (CollegeServiceException e) {
			e.printStackTrace();
			m.addAttribute("errors", e.getMessage());
			return "errors";
		}

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllColleges")
	public String getAllEmployees(Model m) {
		System.out.println("Getting all students");
		m.addAttribute("collegeList", collegeService.getAllDetails());
		return "getCollege";
	}
	
}
