package com.mindtree.webAppDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(value = "/")
	public String index(Model m) {
		m.addAttribute("message", "Welcome to SprignBootMVC Example");
		return "home";
	}
	
}