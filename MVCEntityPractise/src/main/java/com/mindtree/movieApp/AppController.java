package com.mindtree.movieApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

}
