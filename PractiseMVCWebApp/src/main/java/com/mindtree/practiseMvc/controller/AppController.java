package com.mindtree.practiseMvc.controller;

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
	
	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/parallax")
	public String parallax() {
		return "parallax";
	}
	
	@RequestMapping(value = "/transform")
	public String transform() {
		return "transform";
	}

	
}