package com.mindtree.CollegeApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CollegeApp.dto.CollegeDto;
import com.mindtree.CollegeApp.service.CollegeServiceImpl;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "home";
	}
	
}
